package plus.tsonlang;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import java.io.IOException;


public class TsonLexer implements FlexLexer {
    public static class Adapter extends FlexAdapter{
        public Adapter() {
            super(new TsonLexer());
        }
    }

    private CharSequence buf;
    private int startBuf, endBuf;
    private int startToken = 0, endToken = 0;
    private int flag = 0, yyState = 0;
    private int cursor = 0;

    @Override
    public void reset(CharSequence buf, int start, int end, int initialState) {
        flag = 0;
        this.cursor = 0;
        this.buf = buf;
        this.startBuf = 0;         //TODO Rewrite. Temporary fix critical error. `this.startBuf = start;`
        this.endBuf = buf.length();//TODO Rewrite. Temporary fix critical error. `this.endBuf = end;`
        this.startToken = 0;
        this.endToken = 0;
    }


    @Override
    public void yybegin(int state) {
        this.yyState = state;
    }


    @Override
    public int yystate() {
        return yyState;
    }


    @Override
    public int getTokenStart() {
        return startToken;
    }


    @Override
    public int getTokenEnd() {
        return endToken;
    }


    @Override
    public IElementType advance() throws IOException {
        IElementType result;
        //fix syntax errors
        try {
            result = process();
        } catch (Exception e){
            e.printStackTrace();
            startToken = endToken = buf.length();
            flag = 0;
            cursor = 0;
            return null;
        }
        if(startToken >= endToken || endToken > buf.length()){
            startToken = endToken = buf.length();
            flag = 0;
            cursor = 0;
            return null;
        }
        return result;
    }


    protected IElementType process(){
        if(flag == 1){
            int pos = startBuf + cursor;
            if(pos >= buf.length()) {
                startToken = endToken = buf.length();
                flag = 0;
                return null;
            }
            char c = buf.charAt(pos);
            if(c == '\'' || c == '"'){
                flag = 0;
                return pre(TsonElToken.STRING_BOUND);
            }
            onStr();
            return TsonElToken.STRING;
        } else if (flag == 2) {
            flag = 0;
            return onPrimitive();
        } else {
            int pos = startBuf + cursor;
            if(pos >= buf.length()) return null;
            goToChar();

            char c = buf.charAt(pos);

            switch (c){
                case ',': return pre(TsonElToken.COMMA          );
                case '{': return pre(TsonElToken.START_MAP      );
                case '}': return pre(TsonElToken.END_MAP        );
                case '[': return pre(TsonElToken.START_LIST     );
                case ']': return pre(TsonElToken.END_LIST       );
                case '<': return pre(TsonElToken.START_CLASS    );
                case '>': return pre(TsonElToken.END_CLASS      );
                case '=': return pre(TsonElToken.KEY_SEPARATOR  );
                case '(': {
                    flag = 2;
                    return pre(TsonElToken.PRIMITIVE_START);
                }
                case ')': return pre(TsonElToken.PRIMITIVE_END  );
                case '\'':
                case '\"': {
                    flag = 1;
                    return pre(TsonElToken.STRING_BOUND);
                }
                default : return pre(TsonElToken.EMPTY          );
            }
        }
        //return pre(TsonElToken.EMPTY);
    }


    protected IElementType pre(IElementType res){
        startToken = startBuf + cursor;
        ++cursor;
        endToken   = startBuf + cursor;
        return res;
    }


    private IElementType onPrimitive(){
        int start = cursor;
        char c = buf.charAt(startBuf + cursor);

        while (c != ')' && startBuf + cursor < endBuf){
            c = buf.charAt(startBuf + cursor);
            if(c == '\\'){
                ++cursor;
                c = buf.charAt(startBuf + cursor);
            }
            ++cursor;
        }
        --cursor;

        startToken = startBuf + start;
        endToken   = startBuf + cursor;
        String result = buf.subSequence(startToken, endToken).toString();

        try {
            Double.parseDouble(result.replace("_",""));
            return TsonElToken.NUMBER;
        } catch (Exception ignored){}
        if(result.equalsIgnoreCase("true") || result.equalsIgnoreCase("false")){
            return TsonElToken.BOOLEAN;
        }
        return TsonElToken.CLASS;
    }


    private void onStr(){
        int start = cursor;
        char prev = buf.charAt(startBuf + cursor-1),
             c = buf.charAt(startBuf + cursor);

        while (c != prev && startBuf + cursor < endBuf){
            c = buf.charAt(startBuf + cursor);
            if(c == '\\'){
                ++cursor;
                c = buf.charAt(startBuf + cursor);
            }
            ++cursor;
        }
        --cursor;
        startToken = startBuf + start;
        endToken   = startBuf + cursor;
    }


    private boolean goToChar(){
        char c = buf.charAt(startBuf + cursor);
        boolean step = false;

        while (isSpace(c) && startBuf + cursor < endBuf){
            step = true;
            ++cursor;
            c = buf.charAt(startBuf + cursor);
        }
        if(step) --cursor;
        return step;
    }


    private boolean isSpace(char c){
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }
}
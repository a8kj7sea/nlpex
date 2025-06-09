package me.a8kj.nlpex.rules;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.token.impl.LexerToken;
import me.a8kj.mattc.token.attributes.TokenLocation;
import me.a8kj.mattc.tokenizer.attributes.TokenizerApplyResult;
import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.nlpex.category.NLPCategory;

public class NumberRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        return context.hasNext() && (Character.isDigit(context.currentChar()) || context.currentChar() == '.');
    }

    @Override
    public TokenizerApplyResult apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        StringBuilder builder = new StringBuilder();
        boolean dotSeen = false;

        while (context.hasNext()) {
            char c = context.currentChar();
            if (Character.isDigit(c)) {
                builder.append(c);
                context.advance();
            } else if (c == '.' && !dotSeen) {
                dotSeen = true;
                builder.append(c);
                context.advance();
            } else {
                break;
            }
        }

        String value = builder.toString();
        TokenLocation location = new TokenLocation(column, line, start, context.getPosition());

        Token token = new LexerToken(value, NLPCategory.NUMBER, location);

        return TokenizerApplyResult.success(token);
    }
}

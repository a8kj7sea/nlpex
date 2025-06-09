package me.a8kj.nlpex.rules;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.token.impl.LexerToken;
import me.a8kj.mattc.token.attributes.TokenLocation;
import me.a8kj.mattc.tokenizer.attributes.TokenizerApplyResult;
import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.nlpex.category.NLPCategory;

public class WordRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        return context.hasNext() && Character.isLetter(context.currentChar());
    }

    @Override
    public TokenizerApplyResult apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        StringBuilder builder = new StringBuilder();
        while (context.hasNext() && Character.isLetter(context.currentChar())) {
            builder.append(context.currentChar());
            context.advance();
        }

        String value = builder.toString();
        TokenLocation location = new TokenLocation(column, line, start, context.getPosition());

        Token token = new LexerToken(value, NLPCategory.WORD, location);

        return TokenizerApplyResult.success(token);
    }
}

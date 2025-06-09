package me.a8kj.nlpex;


import me.a8kj.mattc.tokenizer.impl.SimpleTokenizer;
import me.a8kj.mattc.tokenizer.registry.RuleRegistry;
import me.a8kj.mattc.utils.TokenizerOutputFormatter;
import me.a8kj.nlpex.rules.ContractionRule;
import me.a8kj.nlpex.rules.NumberRule;
import me.a8kj.nlpex.rules.PunctuationRule;
import me.a8kj.nlpex.rules.WhitespaceRule;
import me.a8kj.nlpex.rules.WordRule;

public class Main {

    public static void main(String[] args) {

        String text = "I'm akj , and hello world !";

        SimpleTokenizer tokenizer = new SimpleTokenizer(text);

        RuleRegistry registry = tokenizer.getRuleRegistry();

        registry.addRule(new WhitespaceRule());
        registry.addRule(new WordRule());
        registry.addRule(new NumberRule());
        registry.addRule(new PunctuationRule());
        registry.addRule(new ContractionRule());

        var result = tokenizer.tokenize();
        var ref = tokenizer.tokenize("bye");

        System.out.println(TokenizerOutputFormatter.format(result));
                System.err.println(TokenizerOutputFormatter.format(ref));

    }
}

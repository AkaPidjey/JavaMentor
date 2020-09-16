package Java_Core_Module_3.Task_3_5_7;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

    @Override
    public Label processText(String text) {
        String[] wordsNeg = getKeywords();
        for (String word : wordsNeg) {
            boolean temp = text.contains(word);
            if (temp) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

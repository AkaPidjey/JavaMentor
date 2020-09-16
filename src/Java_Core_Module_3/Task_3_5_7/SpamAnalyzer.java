package Java_Core_Module_3.Task_3_5_7;

public class SpamAnalyzer extends KeywordAnalyzer{
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

    @Override
    public Label processText(String text) {
        String[] wordsSpam = getKeywords();
        for (String word : wordsSpam) {
            boolean temp = text.contains(word);
            if (temp) {
                return getLabel();
            }
        }
        return Label.OK;
    }
}

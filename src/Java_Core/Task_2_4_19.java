package Java_Core;

public class Task_2_4_19 {
    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();
        for (String rol : roles) {
            result.append(rol + ":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(rol + ":")) {
                    result.append((i + 1) + ")" + textLines[i].substring(rol.length() + 1) + "\n");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}

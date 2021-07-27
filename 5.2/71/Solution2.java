import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir: dirs)
            switch (dir) {
                case ".":
                case "":
                    continue;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    continue;
                default:
                    stack.push(dir);
            }

        StringBuilder builder = new StringBuilder();
        for (String dir: stack)
            builder.append("/").append(dir);

        return builder.length() == 0 ? "/" : builder.toString();
    }
}
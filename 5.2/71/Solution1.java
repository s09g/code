import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String dir: dirs)
            switch (dir) {
                case ".":
                case "":
                    continue;
                case "..":
                    if (!deque.isEmpty()) {
                        deque.removeLast();
                    }
                    continue;
                default:
                    deque.addLast(dir);
            }

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty())
            builder.append("/").append(deque.removeFirst());

        return builder.length() == 0 ? "/" : builder.toString();
    }
}
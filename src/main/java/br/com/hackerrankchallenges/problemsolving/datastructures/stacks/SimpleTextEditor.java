package br.com.hackerrankchallenges.problemsolving.datastructures.stacks;

import br.com.hackerrankchallenges.Executor;

import java.util.Scanner;

public final class SimpleTextEditor extends Executor {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    protected String getResourcePath() {
        return "/problem-solving/simple-text-editor/input07.txt";
    }

    @Override
    protected void execute() {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        int top = -1;
        String[] states = new String[300_000];

        StringBuilder output = new StringBuilder();
        String s = "";

        for (int i=0; i<q; i++) {
            int t = scanner.nextInt();
            switch (t) {
                case 1:
                    states[++top] = s;
                    String w = scanner.next();
                    s += w;
                    break;
                case 2:
                    states[++top] = s;
                    int k = scanner.nextInt();
                    s = s.substring(0, s.length()-k);
                    break;
                case 3:
                    int kth = scanner.nextInt();
                    output.append(s.charAt(kth-1)).append(LINE_SEPARATOR);
                    break;
                case 4:
                    s = states[top--];
                    break;
            }
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        new SimpleTextEditor().executeMeasuringTime();
    }
}

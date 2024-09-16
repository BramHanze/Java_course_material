package section1_intro.part1_language_basics;

public class GeometryAnalyser {
    public static void main(String[] args) {
        int p1x = Integer.parseInt(args[0]);
        int p1y = Integer.parseInt(args[1]);
        int p2x = Integer.parseInt(args[2]);
        int p2y = Integer.parseInt(args[3]);
        int sideOne = Math.abs(p1x - p2x);
        int sideTwo = Math.abs(p1y - p2y);
        if (args[4].equals("surf")){
            System.out.println(sideOne * sideTwo);
        }
        if (args[4].equals("dist")){
            double distance = Math.sqrt(Math.pow(sideOne,2) + Math.pow(sideTwo,2));
            System.out.printf("%.1f\n", distance);
        }

    }
}

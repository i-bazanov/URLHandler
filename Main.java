public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length == 2) {
            URLHandler.checkWheel(Long.parseLong(args[0]), args[1]);
        }
        else {
            System.out.println("Need to set 2 parameters: \n" +
                    " first is delay in sec \n" +
                    " second is URL");
        }
    }
}

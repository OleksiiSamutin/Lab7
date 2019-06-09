public class IndexOutOfRange extends Exception {


    @Override
    public void printStackTrace() {
        System.out.println("Your index is out of range!");
        super.printStackTrace();
    }
}

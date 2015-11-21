import java.awt.EventQueue;

public final class StudyMain {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private StudyMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the Study GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final StudyGUI gui = new StudyGUI();
//                gui.start();
            }
        });
    }
}
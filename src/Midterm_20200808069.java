import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Midterm_20200808069 {
    static int acc = 0;
    static int[] mainmemory = new int[256];
    static int prc = 0;
    static int f = 0;


    public static void LOAD(int i) {
        acc = i;
        ++prc;
    }

    public static void STORE(int M) {
        if (M < mainmemory.length && M >= 0) {
            mainmemory[M] = acc;
            ++prc;
        } else {
            System.out.println("Memory location is out of memory size");
            System.exit(1);
        }

    }

    public static void CMPM(int M) {
        if (M < mainmemory.length && M >= 0) {
            f = Integer.compare(acc, mainmemory[M]);
            ++prc;
        } else {
            System.out.println("Memory location is out of memory size");
            System.exit(1);
        }

    }

    public static void CJMP(int i) {
        if (f > 0) {
            prc = i;
        } else {
            ++prc;
        }

    }

    public static void LOADM(int M) {
        if (M < mainmemory.length && M >= 0) {
            acc = mainmemory[M];
            ++prc;
        } else {
            System.out.println("Memory location is out of memory size");
            System.exit(1);
        }

    }

    public static void ADDM(int M) {
        if (M < mainmemory.length && M >= 0) {
            acc += mainmemory[M];
            ++prc;
        } else {
            System.out.println("Memory location is out of memory size");
            System.exit(1);
        }

    }

    public static void ADD(int i) {
        acc += i;
        ++prc;
    }

    public static void JMP(int i) {
        prc = i;
    }

    public static void DISP() {
        System.out.println("Result:" + acc );
        ++prc;
    }

    public static void HALT() {
        System.exit(0);
    }

    public static void SUBM(int M) {
        if (M < mainmemory.length && M >= 0) {
            acc -= mainmemory[M];
            ++prc;
        } else {
            System.out.println("Memory location is out of memory size");
            System.exit(1);
        }

    }

    public static void SUB(int i) {
        acc -= i;
        ++prc;
    }

    public static void MUL(int n) {
        acc *= n;
        ++prc;
    }

    public static void MULM(int M) {
        if (M < mainmemory.length && M >= 0) {
            acc *= mainmemory[M];
            ++prc;
        } else {
            System.out.println("Memory location is out of memory size");
            System.exit(1);
        }

    }

    public static void START() {
        System.out.println("Execution is started now.");
        ++prc;
    }

    public static void main(String[] args) throws Exception {
        String ss=args[0];
        File f = new File(ss);
        Scanner scanner = new Scanner(f);

        ArrayList<String> lists = new ArrayList();
        ArrayList<String> variables = new ArrayList();
        ArrayList instructions = new ArrayList();

        while(true) {
            while(scanner.hasNext()) {
                lists.add(scanner.next());
                instructions.add(scanner.next());
                if (!((String)instructions.get(instructions.size() - 1)).equalsIgnoreCase("START")
                        && !((String)instructions.get(instructions.size() - 1)).equalsIgnoreCase("DISP")
                        && !((String)instructions.get(instructions.size() - 1)).equalsIgnoreCase("HALT")) {
                    variables.add(scanner.next());
                } else {
                    variables.add("");
                }
            }

            int i = prc;

            while(true) {
                String var76 = ((String)instructions.get(i)).toUpperCase();
                byte var80= -1;
                switch(var76.hashCode()) {
                    case 64641:
                        if (var76.equals("ADD")) {
                            var80 = 13;
                        }
                        break;
                    case 73581:
                        if (var76.equals("JMP")) {
                            var80 = 6;
                        }
                        break;
                    case 76708:
                        if (var76.equals("MUL")) {
                            var80 = 9;
                        }
                        break;
                    case 82464:
                        if (var76.equals("SUB")) {
                            var80 = 12;
                        }
                        break;
                    case 2003948:
                        if (var76.equals("ADDM")) {
                            var80 = 7;
                        }
                        break;
                    case 2069578:
                        if (var76.equals("CJMP")) {
                            var80 = 5;
                        }
                        break;
                    case 2072551:
                        if (var76.equals("CMPM")) {
                            var80 = 8;
                        }
                        break;
                    case 2098594:
                        if (var76.equals("DISP")) {
                            var80 = 1;
                        }
                        break;
                    case 2209857:
                        if (var76.equals("HALT")) {
                            var80 = 2;
                        }
                        break;
                    case 2342118:
                        if (var76.equals("LOAD")) {
                            var80 = 11;
                        }
                        break;
                    case 2378025:
                        if (var76.equals("MULM")) {
                            var80 = 14;
                        }
                        break;
                    case 2556461:
                        if (var76.equals("SUBM")) {
                            var80 = 10;
                        }
                        break;
                    case 72605735:
                        if (var76.equals("LOADM")) {
                            var80 = 4;
                        }
                        break;
                    case 79219778:
                        if (var76.equals("START")) {
                            var80 = 0;
                        }
                        break;
                    case 79233217:
                        if (var76.equals("STORE")) {
                            var80 = 3;
                        }
                }

                switch(var80) {
                    case 0:
                        START();
                        break;
                    case 1:
                        DISP();
                        break;
                    case 2:
                        HALT();
                        break;
                    case 3:
                        STORE(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 4:
                        LOADM(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 5:
                        CJMP(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 6:
                        JMP(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 7:
                        ADDM(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 8:
                        CMPM(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 9:
                        MUL(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 10:
                        SUBM(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 11:
                        LOAD(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 12:
                        SUB(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 13:
                        ADD(Integer.parseInt((String)variables.get(i)));
                        break;
                    case 14:
                        MULM(Integer.parseInt((String)variables.get(i)));
                }

                i = prc;
            }
        }
    }
}



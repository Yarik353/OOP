package labs;

/**
 * C2 = 1 O1 = "-"
 * C3 = 1 C = 1
 * C5 = 1 O2 = "/"
 * C7 = 0 тип індексів i та j = byte
 **/
public class jc {
        public static void main(String[] args) {
            byte n = 2;
            byte m = 2;
            byte a = 1;
            byte b = 1;
            double S = 0;
            final byte C = 1;
            for (byte i = a; i <= n; i++){
                for(byte j = b; j <= m; j++){
                    if((double)(i - C) ==0){
                        continue;
                    }
                    S = S + (((double)(i)/(double)(j)) / (double)(i - C));

                }
            }
            System.out.println(S);

            }
}

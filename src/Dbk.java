//import java.util.Scanner;

class Binomial {
    float p,q;
    int n, x;

    public Binomial(float p, int n, int x) {
        this.p = p;
        this.q = 1- p;
        this.n = n;
        this.x = x;
    }
    Binomial(){

    }

    int faktorisasi(int number){
        int hasil =1;
        for(int i = 1; i <= number; i++){
            hasil *= i ; 
        }
    
        return hasil;
    }

    float kombinasi(){
        int atas = faktorisasi(this.n);
        int bawah1 = faktorisasi(this.x);
        int nx = this.n - this.x;
        int bawah2 = faktorisasi(nx);
        int bawah3 = bawah1 * bawah2;
        float hasil = atas / bawah3;
        return hasil;
    }

    float binomial(){
        float hasil =0f;
        float pe =1f;
        float qi =1f;
        for(int i = 0; i < x ; i++){
            pe *= p;
        }
        for(int j = 0; j < n-x ; j++){
            qi *= q;
        }
        hasil = pe * qi;
        return hasil;
    }

    float hasil(){
        return kombinasi()*binomial();
    }
    
}

class Kumulatif extends Binomial{
    int[] x;
    float p,q;
    int n;

    public Kumulatif(float p, int n,int ...x){
        this.x =x;
        this.p = p;
        this.q = 1-p;
        this.n = n;
    }
    Kumulatif(){

    }
    float hasil(){
        float hasil = 0f;
        Binomial s = new Binomial(p,n,0);
        for (int i : x) {
            s.x = i;
            hasil += s.hasil();
        }
        return hasil;
    }
}

public class Dbk {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int flag =0;
        // float pe = 0;
        // int en = 0;
        // int[] ex = {};

        // while(flag ==0){
        //     System.out.printf("Input P : ");
        //     pe = sc.nextFloat();
        //     System.out.printf("Input N : ");
        //     en = sc.nextInt();
        //     char flag2 = ';';
        //     int i =0;
        //     System.out.println("Input X -> akhiri dengan (.) ");
        //     while(flag2 != '.'){
        //         flag2 = sc.next().charAt(i);
        //         ex[i] = Character.getNumericValue(flag2);
        //         i++;
        //     }
        //     Kumulatif calc = new Kumulatif(pe,en,ex);
        //     System.out.println("Hasil : " + calc.hasil());
        // }
        // sc.close();
        Kumulatif no1a = new Kumulatif(2/5f, 5, 0);
        System.out.println("No 1a = " + no1a.hasil());
        Kumulatif no1b = new Kumulatif(2/5f, 5, 3,4,5);
        System.out.println("No 1b = " + no1b.hasil());
        Kumulatif no1c = new Kumulatif(2/5f, 5, 2);
        System.out.println("No 1c = " + no1c.hasil());
        System.out.println();
        Kumulatif no2a = new Kumulatif(4/7f, 10, 1);
        System.out.println("No 2a = " + no2a.hasil());
        Kumulatif no2b = new Kumulatif(4/7f, 10, 8,9,10);
        System.out.println("No 2b = " + no2b.hasil());
        Kumulatif no2c = new Kumulatif(4/7f, 10, 0,1,2);
        System.out.println("No 2c = " + no2c.hasil());
        System.out.println();
        Kumulatif no3a = new Kumulatif(15/100f, 4, 4);
        System.out.println("No 3a = " + no3a.hasil());
        Kumulatif no3b = new Kumulatif(15/100f, 4, 0,1,2);
        System.out.println("No 3b = " + no3b.hasil());
        Kumulatif no3c = new Kumulatif(15/100f, 4, 3,4);
        System.out.println("No 3b = " + no3c.hasil());

        System.out.println();
        Kumulatif ta = new Kumulatif(15/100f, 4, 0);
        System.out.println("test = " + ta.hasil());
        Kumulatif ta2 = new Kumulatif(15/100f, 4, 1);
        System.out.println("test = " + ta2.hasil());
        Kumulatif ta3 = new Kumulatif(15/100f, 4, 2);
        System.out.println("test = " + ta3.hasil());
        
    }
}

package application;


public class Operand {
   String operand=new String();

      

      private int[] c=new int[2]; //문자열 두개를 더하여 저장할 값

      private int lenC=0; //C의 길이

      private String result=new String();//최종 결과가 저장된 문자열

      
      Operand(){}
      Operand(String operand){

         this.operand=operand;

      }

      
      String getResult() {
          return result;
       }
      
      void reverse(String op) {

          /*add code*/
         for(int i=op.length()-1;i>=0;i--){
               operand+=String.valueOf(op.charAt(i));
           }

      }

      

      void addOp1() {

          c=new int[operand.length()+1];

          for(int i=0;i<operand.length();i++) {

             c[i]+=Integer.valueOf(operand.charAt(i))-48;

                 if(c[i]>=10) {

                  c[i+1]+=c[i]/10;

                  c[i]=c[i]%10;

                 }

          }

      }

      

      

      void add(String op) {

          addOp1();

          

         if(op.length()>operand.length()) {

            int[] temp=new int[op.length()+1];

            

            for(int i=0; i<op.length(); i++) {

                    temp[i]+=Integer.valueOf(op.charAt(i))-48;

               }

            for(int i=0; i<operand.length(); i++) {

                    temp[i]+=c[i];

                    if(temp[i]>=10) {

                     temp[i+1]+=temp[i]/10;

                     temp[i]=temp[i]%10;

                    }

            }

            c=new int[temp.length];

            c=temp.clone();

            

         }

         

         else {

         for(int i=0; i<op.length(); i++) {

                 c[i]+=Integer.valueOf(op.charAt(i))-48;

                 if(c[i]>=10) {

                  c[i+1]+=c[i]/10;

                  c[i]=c[i]%10;

                 }

            }

         }

         

         lenC=c.length-1;

         int i=lenC;

         while(c[i]==0) {

            this.lenC-=1;

            i--;

         }

         for(i=lenC;i>=0;i--) {
             result+=Integer.toString(c[i]);
          }

         

      

      

      }

      

      void subtract(String op) {

         addOp1();

         

         if(op.length()>operand.length()) {

            int[] temp=new int[op.length()+1];

            

            for(int i=0; i<op.length(); i++) {

                    temp[i]+=Integer.valueOf(op.charAt(i))-48;

               }

            for(int i=0; i<operand.length(); i++) {

                    temp[i]-=c[i];

                    if(temp[i]<0) {

                     temp[i]=temp[i]+10;

                     temp[i+1]-=1;

                    }

            }

            c=new int[temp.length];

            c=temp.clone();

         }

         else {

           for(int i=0; i<op.length(); i++) {

                 c[i]-=Integer.valueOf(op.charAt(i))-48;

                 if(c[i]<0) {

                   c[i]=c[i]+10;

                  c[i+1]-=1;

                 }

           }   

         }

           lenC=c.length-1;

            int i=lenC;

            while(c[i]==0&&c[i]!=0) {

               this.lenC-=1;

               i--;

            }

           

            for(i=lenC;i>=0;i--) {
                result+=Integer.toString(c[i]);
             }

           

      }



      void print() { //결과 출력

         System.out.println(result);

      }

      
      
}
         


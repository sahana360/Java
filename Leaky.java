import java.util.Scanner;

public class Leaky {

            public static void main(String args[]){

                        Scanner sc=new Scanner(System.in);

                        int bucket=0,op_rate,i,n,bsize,a;

                        System.out.println("enter number of packets");

                        n=sc.nextInt();

                        int pkt[]=new int[n];

                        System.out.println("enter he output rate of the bucket");

                        op_rate=sc.nextInt();

                        System.out.println("enter the bucket size");

                        bsize=sc.nextInt();

                        System.out.println("enter the arriving packets(size)");

                        for(i=0;i<n;i++)

                                    pkt[i]=sc.nextInt();

                        System.out.println("\nsec\tpsize\tbucketsize\taccept/reject\tpkt_send\tremaining");

                        System.out.println("-----------------------------------------------------------");

                        for(i=0;i<n;i++)

                        {

                                    System.out.print(i+1+"\t"+pkt[i]+"\t");

                                    if(bucket+pkt[i]<=bsize)

                                    {

                                                bucket+=pkt[i];

                                                System.out.println(bucket+"\t\taccept\t\t"+min(bucket,op_rate)+"\t\t"+sub(bucket,min(bucket,op_rate))+"\n");

                                                bucket=sub(bucket,min(bucket,op_rate));

                                    }

                                    else

                                    {	
					System.out.println(bucket+"\t\treject\t"+"\t"+"0"+"\t\t"+bucket+"\n");

                                                
                                    }

                        }

                        while(bucket!=0)

                        {

                                    System.out.print(++i +"\t0 \t"+bucket+"\t\taccept\t\t"+min(bucket,op_rate)+"\t\t"+sub(bucket,op_rate)+"\n");

                                    bucket=sub(bucket,op_rate);

                        }

                        sc.close();

            }

            static int min(int a,int b)

{

                        return(a<b)?a:b;

            }

             static int sub(int a,int b)

{

                        return(a-b)>0?(a-b):0;

            }

}

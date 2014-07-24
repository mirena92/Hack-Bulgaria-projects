Send Email  
==  
  
This program sends an email to someone, if you have an account in `abv.bg` or `gmail.com`.  
It uses the apache commons-email library.  
  
### How to run?  
The program receives eight arguments:  
1. recipient's email  
2. email subject   
3. message  
4. sender's email  
5. sender's name  
6. sender's username for login (for `abv` your username have to ends with @abv.bg)  
7. sender's password  
8. URL of image or gif file, which you want to send.  This argument is not compulsory.
  
**To run**, just type `java -jar SendEmail.jar` followed by the eight arguments in the terminal.  
  
For example `"reni@gmail.com" "Hello" "This is test email" "anny@gmail.com"  
"Ani" "anny@gmail." "121212" "http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif"`
  
 
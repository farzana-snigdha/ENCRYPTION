# ENCRYPTION
### RSA ENCRYPTION
**__OPERATION__**

RSA involves a public key and private key. The public key can be known to everyone; it is used to encrypt messages. Messages encrypted using the public key can only be decrypted with the private key. The keys for the RSA algorithm are generated the following way:
  1. Choose two different large random prime numbers **p** and **q**.
  2. Calculate **n**=_p_*_q_ here,**n** is the modulus for the public key and the private keys.
  3. Calculate the number of co-prime: phi (n)=(p-1)(q-1).
  4. Choose an integer **e** such that 1 < **e** <phi (n), and **e** is co-prime to phi (n); i.e.: **e** and phi (n) share no factors other than 1; gcd(**e**,phi (n)) = 1.   here,**e** is released as the public key exponent.
  5. Compute **d** to satisfy the congruence relation **de**=1 mod(phi(n)) . i.e.:**de=1+xphi(n)** for some integer **x**.(Simply to say **d=e^-1 mod(phi(n))**.  here, **d** is kept as the private key exponent.
  
  **__ENCRYPTING MESSAGE__**
  
  Alice gives her public key (**n,e**) to Bob and keeps her private key secret. Bob wants to send message **M** to Alice.
  First he turns **M** into its numerical value **m**. To encrypt the message Bob will use the equation, **__c=m^e mod(n)__** and send **c** to Alice. 
  
  **__DECRYPTING MESSAGE__**
  
  Alice can recover **m** from **c** by using her private key **d** in the following procedure:
**__m=c^d mod n__**
 
  **__ WORKING EXAMPLE__**
  
  First we need to-
  1.Choose 2 random prime number: **p**=2,**q**=7. 
  2.Compute **n**=pq=2*7=14
  3.Compute the number of co-prime: phi(n)=(p-1)(q-1)=1*6=6
  4.Choose e: Possible numbers that is co-prime with 3120 [gcd(e,6)=1] : 5. Therefor e=5
  5.Choose d: inverse of **e mod phi(n)**= inverse of 5 mod 6= -1,5,11,17 ... . d=5
  TO ENCRYPT **b**:
    The public key is (n=14,e=5) and b=2.
    c=2^5 mod 14
     =4
   **TO DECRYPT :**
   Private key d=5
   m=c^5 mod 14
    =4^5 mod 14
    =2
    =b
    
    

# Progetto Sistemi Operativi 

L'applicazione è divisa in un Client e un Server. Il Server rimane in ascolto su una porta socket predefinita e 
opererà il calcolo del fattoriale del numero inviato dal Client.


Il Server crea un thread per ogni richiesta ricevuta in modo da effetturare i calcoli in parallelo. 
Anche il Client usa una architettura multi - thread per inviare in parallelo più richieste al Server. 

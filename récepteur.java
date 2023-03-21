// Créer un DatagramSocket pour écouter sur un port spécifique
int listenPort = 1234;
DatagramSocket socket = new DatagramSocket(listenPort);

// Créer un tableau d'octets pour stocker les données reçues
byte[] buffer = new byte[1024];

// Recevoir le paquet de données
DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
socket.receive(packet);

// Écrire les données reçues dans un nouveau fichier
File outputFile = new File("path/to/new-file");
Files.write(outputFile.toPath(), buffer);

// Fermer le socket
socket.close();
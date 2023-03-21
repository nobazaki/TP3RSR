// Créer un DatagramSocket
DatagramSocket socket = new DatagramSocket();

// Charger le fichier en tant que tableau d'octets
File file = new File("path/to/file");
byte[] fileBytes = Files.readAllBytes(file.toPath());

// Créer un paquet de données avec le tableau d'octets
InetAddress receiverAddress = InetAddress.getByName("receiver-hostname");
int receiverPort = 1234;
DatagramPacket packet = new DatagramPacket(fileBytes, fileBytes.length, receiverAddress, receiverPort);

// Envoyer le paquet
socket.send(packet);

// Fermer le socket
socket.close();

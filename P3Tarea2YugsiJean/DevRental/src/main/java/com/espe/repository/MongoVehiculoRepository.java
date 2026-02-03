package com.espe.repository;

import com.espe.model.Vehiculo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoVehiculoRepository implements IVehiculoRepository {

    private static MongoVehiculoRepository instancia;

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> vehiculosCollection;

    private static final String CONNECTION_STRING =
            "mongodb+srv://Yercox:Jeansuper101@cluster0.pgpjnm4.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "dvrental";
    private static final String COLLECTION_NAME = "vehiculos";

    public MongoVehiculoRepository() {
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            vehiculosCollection = database.getCollection(COLLECTION_NAME);
            System.out.println("MongoVehiculoRepository (Singleton) inicializado");
        } catch (Exception e) {
            System.err.println("Error al conectar con MongoDB: " + e.getMessage());
            throw new RuntimeException("Error al inicializar MongoVehiculoRepository", e);
        }
    }

    public static synchronized MongoVehiculoRepository getInstance() {
        if (instancia == null) {
            instancia = new MongoVehiculoRepository();
        }
        return instancia;
    }

    @Override
    public void guardar(Vehiculo v) {
        try {
            Document docVehiculo = new Document()
                    .append("placa", v.getPlaca())
                    .append("marca", v.getMarca())
                    .append("modelo", v.getModelo())
                    .append("precioDia", v.getPrecioDia());

            vehiculosCollection.insertOne(docVehiculo);
            System.out.println("Vehiculo guardado en MongoDB: " + v.getPlaca());
        } catch (Exception e) {
            System.err.println("Error al guardar vehiculo: " + e.getMessage());
            throw new RuntimeException("Error al guardar vehículo en MongoDB", e);
        }
    }


}
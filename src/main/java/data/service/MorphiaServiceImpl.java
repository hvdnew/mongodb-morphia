package data.service;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaServiceImpl implements MorphiaService {

    private final Datastore datastore;

    public MorphiaServiceImpl(String dbName) {

        Morphia morphia = new Morphia();

        this.datastore = morphia.createDatastore(new MongoClient(), dbName);
        this.datastore.ensureIndexes();

    }

    @Override
    public Datastore getDatastore() {

        return this.datastore;

    }

}

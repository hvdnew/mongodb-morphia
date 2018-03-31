package data.service;

import org.mongodb.morphia.Datastore;

public interface MorphiaService {

    Datastore getDatastore();

}

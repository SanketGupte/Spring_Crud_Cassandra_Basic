package com.sanket.app.ws.Repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.sanket.app.ws.Entity.Products;

@Repository
public interface ProductRepository extends CassandraRepository<Products, Long>{

}

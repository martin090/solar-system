package com.martinsanguin.solarsystem.repository;

import com.martinsanguin.solarsystem.entities.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    @Query(value = "SELECT day FROM Weather WHERE perimeter = (SELECT max(perimeter) FROM Weather)")
    public List<Integer> findDayWithMaxPerimeter();
}

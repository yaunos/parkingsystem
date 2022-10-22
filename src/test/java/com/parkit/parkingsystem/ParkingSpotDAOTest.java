package com.parkit.parkingsystem;

import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.model.ParkingSpot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.times;

public class ParkingSpotDAOTest {
    @InjectMocks
    private ParkingSpotDAO parkingSpotDAO;

    @Mock
    private static PreparedStatement preparedStatement;
    @Mock
    Connection connection;

    //On mock l'accès à la config de la base dans le rép config
    @Mock
    DataBaseTestConfig databaseConfig;

    @Mock
    private ResultSet resultSet;
    private ParkingSpot parkingSpot;

    @BeforeEach
    public void init() throws SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(connection.createStatement()).thenReturn(preparedStatement);
        Mockito.when(databaseConfig.getConnection()).thenReturn(connection);
        parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
    }

    @Test
    void getNextAvailableSlotTest() throws SQLException {
        Mockito.when(connection.prepareStatement(DBConstants.GET_NEXT_PARKING_SPOT)).thenReturn(preparedStatement);
        Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.next()).thenReturn(true);
        Mockito.when(resultSet.getInt(1)).thenReturn(2);

        int nextAvailableSlot = parkingSpotDAO.getNextAvailableSlot(ParkingType.CAR);
        assertEquals(2, nextAvailableSlot);
        Mockito.verify(preparedStatement, times(1)).executeQuery();
    }

}



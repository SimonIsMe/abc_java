package Notification.Repositories.HashMapRepositoryClasses;

import Connection.Client.TestClient;
import Notification.Settings;
import Connection.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObserversTest
{
    private Connection _connection;

    @Before
    public void setUp() throws Exception
    {
        this._connection = new Connection(new TestClient());
    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void testCountEmptyObserver() throws Exception
    {
        Observers observers = new Observers();
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 0);
    }

    @Test
    public void testCountCreateObserver() throws Exception
    {
        Observers observers = new Observers();
        observers.addObserver(this._connection, "user", new Settings(true, false, false));
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 1);
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 0);
    }

    @Test
    public void testCountUpdateObserver() throws Exception
    {
        Observers observers = new Observers();
        observers.addObserver(this._connection, "user", new Settings(false, true, false));
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 1);
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 0);
    }

    @Test
    public void testCountDeleteObserver() throws Exception
    {
        Observers observers = new Observers();
        observers.addObserver(this._connection, "user", new Settings(false, false, true));
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 1);
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 0);
    }

    @Test
    public void testRemoveCreateObserver() throws Exception
    {
        Observers observers = new Observers();
        observers.addObserver(this._connection, "user", new Settings(true, false, false));
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 1);

        assertTrue(observers.removeObserver(this._connection, "user"));
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 0);
    }

    @Test
    public void testRemoveCreateAndUpdateObserver() throws Exception
    {
        Observers observers = new Observers();

        observers.addObserver(this._connection, "user", new Settings(true, true, false));
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 1);
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 1);
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 0);

        assertTrue(observers.removeObserver(this._connection, "user"));
        assertEquals(observers.countConnections(Observers.CREATE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.UPDATE_TYPE, "user"), 0);
        assertEquals(observers.countConnections(Observers.DELETE_TYPE, "user"), 0);
    }
}
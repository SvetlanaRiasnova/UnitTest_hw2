package Test.seminars.second.hw;

import org.junit.jupiter.api.Test;
import seminars.second.hw.Car;
import seminars.second.hw.Motorcycle;
import seminars.second.hw.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;


class VehicleTest {
    Car car = new Car("Tyota", "Allion", 2013);
    Motorcycle moto = new Motorcycle("Harley-Davidson", "Breakout", 2021);

    //проверка того, что экземпляр объекта Car также является экземпляром
    // транспортного средства; (instanceof)
    @Test
    void testCarIsInstanceOfVehicle() {
        assertThat(car instanceof Vehicle);
    }

    //проверка того, объект Car создается с 4-мя колесами
    @Test
    void WheelsCarCountFour() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    //проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void MotorcycleWheelsCountTow() {
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }

    //проверка того, объект Car развивает скорость 60 в режиме тестового вождения
    // (testDrive())
    @Test
    void CarTestDriveSpeed() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    //проверка того, объект Motorcycle развивает скорость 75
    // в режиме тестового вождения (testDrive())
    @Test
    void MotoTestDriveSpeed() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения
    // транспорта) машина останавливается (speed = 0)
    @Test
    void CarStopTest() {
        car.testDrive();
        System.out.println("Car speed is " + car.getSpeed());
        car.park();
        System.out.println("Car speed is " + car.getSpeed() + " the car stopped");
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park
    //т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void parkMotorcycle() {
        moto.testDrive();
        System.out.println("Moto speed is " + car.getSpeed());
        moto.park();
        System.out.println("Car speed is " + car.getSpeed() + " the car stopped");
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}
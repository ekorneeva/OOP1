package ru.netology.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    @Order(1)
    @DisplayName("Set station")
    public void shouldSetStation() {
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    @Order(2)
    @DisplayName("Increase station from current to next")
    public void shouldIncreaseStation() {
        radio.setCurrentStation(5);
        radio.nextStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    @Order(3)
    @DisplayName("Decrease station from current to previous")
    public void shouldDecreaseStation() {
        radio.setCurrentStation(3);
        radio.previousStation();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    @Order(4)
    @DisplayName("Set station over maximum (negative test)")
    public void shouldNotSetStationOverMax() {
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    @Order(5)
    @DisplayName("Set station under minimum (negative test)")
    public void shouldNotSetStationUnderMin() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    @Order(6)
    @DisplayName("Change up station to next if current station is 9")
    public void shouldChangeUpStationIfCurrentIs9() {
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    @Order(7)
    @DisplayName("Change up station to previous if current station is 0")
    public void shouldChangeUpStationIfCurrentIs0() {
        radio.previousStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    @Order(8)
    @DisplayName("Increase volume from current to next")
    public void shouldIncreaseVolume() {
        radio.setCurrentVolume(9);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    @Order(9)
    @DisplayName("Decrease volume from current to previous")
    public void shouldDecreaseVolume() {
        radio.setCurrentVolume(4);
        radio.decreaseVolume();
        assertEquals(3, radio.getCurrentVolume());
    }

    @Test
    @Order(10)
    @DisplayName("Increase volume if current volume is 10")
    public void shouldNotIncreaseVolumeIfCurrentIs10() {
        radio.setCurrentVolume(10);
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    @Order(11)
    @DisplayName("Decrease volume if current volume is 0")
    public void shouldNotDecreaseVolumeIfCurrentIs0() {
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    @Order(12)
    @DisplayName("Set volume over maximum (negative test)")
    public void shouldNotSetVolumeOverMax() {
        radio.setCurrentVolume(11);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    @Order(13)
    @DisplayName("Set volume under minimum (negative test)")
    public void shouldNotSetVolumeUnderMin() {
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

}
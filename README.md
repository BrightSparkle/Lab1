# Container

[![Java Version](https://img.shields.io/badge/Java-17%2B-blue)](https://openjdk.java.net/)
[![JUnit5](https://img.shields.io/badge/JUnit-5.8.2-brightgreen)](https://junit.org/junit5/)

Реализация пользовательского контейнера для хранения целых чисел с использованием динамического массива.

## Особенности

- Хранение произвольного количества целых чисел (Integer)
- Динамическое расширение внутреннего массива
- Реализация интерфейса Iterable для использования в for-each циклах
- Базовые операции:
  - Добавление элементов
  - Получение элементов по индексу
  - Удаление элементов
  - Получение размера контейнера
- Проверка границ индексов
- Исключение null-значений при добавлении

## Требования

- Java 17 или новее
- Maven (для сборки и тестирования)

## Установка

1. Склонируйте репозиторий:
```bash
git clone [https://github.com/BrightSparkle/Lab1]

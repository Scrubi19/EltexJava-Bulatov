package ru.eltex.laba1;

public interface IcrudAction {
    /**
     * create - заполнение объекта случайными значениями и инкремент счётчика
     * read – вывод данных на экран.
     * update – ввод данных с клавиатуры.
     * delete – принудительное зануление данных в объекте и декремент счетчика.
     */
    void create();
    void read();
    void update();
    void delete();
}

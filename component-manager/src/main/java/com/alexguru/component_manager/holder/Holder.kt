package com.alexguru.component_manager.holder

interface Holder {

    /**
     * Проверка, есть ли обьект по данному ключу
     * @param key
     */
    fun isExist(key: String): Boolean

    /**
     * Полуение обьекта по ключу из хранилища
     * @param key
     */
    fun get(key: String): Any?

    /**
     * Поиск обьекта в хранилище
     * @param predicate
     */
    fun findComponent(predicate: (Any) -> Boolean): Any?

    /**
     * Добавление обьекта в хранилище
     * @param key
     * @param component
     */
    fun add(key: String, component: Any)

    /**
     * Удаление обьекта из хранилища по ключу
     * @param key
     */
    fun remove(key: String)

    /**
     * Очистка хранилища
     */
    fun clear()
}
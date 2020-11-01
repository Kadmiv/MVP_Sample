package com.kadmiv.mvp_sample.repository.preferences;

import java.util.Set;

/**
 * Created by Kadmiv on 30.10.2020 11:27
 * <p>
 * Абстракный класс для работы с SharedPreferences - для нормальной подмены
 * По SOLID короче )
 */
public abstract class AbstractPreferenceHelper {

    public abstract void saveString(String value, String key);

    public abstract void saveStringSet(String key, Set<String> values);

    public abstract void saveInt(String key, int value);

    public abstract void saveLong(String key, long value);

    public abstract void saveFloat(String key, float value);

    public abstract void saveBoolean(String key, boolean value);

    public abstract String loadString(String value, String defValue);

    public abstract Set<String> loadStringSet(String key, Set<String> defValue);

    public abstract int loadInt(String key, int defValue);

    public abstract long loadLong(String key, long defValue);

    public abstract float loadFloat(String key, float defValue);

    public abstract boolean loadBoolean(String key, boolean defValue);

    public abstract void remove(String key);

    public abstract void clear();

    public abstract void saveObject(Object value, String key);

}

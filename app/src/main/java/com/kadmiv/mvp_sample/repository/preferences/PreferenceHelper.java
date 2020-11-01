package com.kadmiv.mvp_sample.repository.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

/**
 * Created by Kadmiv on 30.10.2020 11:27
 * <p>
 * Класс для работы с SharedPreferences
 * Сделан, чтобы не создавать постоянно префересы для каждого активи, а сделать общим для приложения.
 */
public class PreferenceHelper extends AbstractPreferenceHelper {
    Logger LOG = LoggerFactory.getLogger(PreferenceHelper.class);

    private SharedPreferences store;
    private final String TAG_APP_PREFERENCES = "TAG_APP_PREFERENCES";
    private Context context;

    public PreferenceHelper(Context context) {
        this.context = context;
        store = context.getSharedPreferences(TAG_APP_PREFERENCES, Context.MODE_PRIVATE);
    }


    @Override
    public void saveString(String value, String key) {
        SharedPreferences.Editor editor = store.edit();
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public void saveStringSet(String key, Set<String> values) {
        SharedPreferences.Editor editor = store.edit();
        editor.putStringSet(key, values);
        editor.apply();
    }

    @Override
    public void saveInt(String key, int value) {
        SharedPreferences.Editor editor = store.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public void saveLong(String key, long value) {
        SharedPreferences.Editor editor = store.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public void saveFloat(String key, float value) {
        SharedPreferences.Editor editor = store.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public void saveBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = store.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public String loadString(String key, String defValue) {
        return store.getString(key, defValue);
    }


    @Override
    public Set<String> loadStringSet(String key, Set<String> defValue) {
        return store.getStringSet(key, defValue);
    }

    @Override
    public int loadInt(String key, int defValue) {
        return store.getInt(key, defValue);
    }

    @Override
    public long loadLong(String key, long defValue) {
        return store.getLong(key, defValue);
    }

    @Override
    public float loadFloat(String key, float defValue) {
        return store.getFloat(key, defValue);
    }

    @Override
    public boolean loadBoolean(String key, boolean defValue) {
        return store.getBoolean(key, defValue);
    }

    @Override
    public void remove(String key) {
        SharedPreferences.Editor editor = store.edit();
        editor.remove(key);
        editor.apply();
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = store.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    public void saveObject(Object object, String key) {
        try {
            String value = new Gson().toJson(object);
            // Данные преференсов
//            LOG.info(String.format("| key= %s object = %s",key,value));
            saveString(value, key);
        } catch (Exception ex) {
            LOG.error("", ex);
        }
    }

}

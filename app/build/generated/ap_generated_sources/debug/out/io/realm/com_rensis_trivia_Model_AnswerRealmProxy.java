package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_rensis_trivia_Model_AnswerRealmProxy extends com.rensis.trivia.Model.Answer
    implements RealmObjectProxy, com_rensis_trivia_Model_AnswerRealmProxyInterface {

    static final class AnswerColumnInfo extends ColumnInfo {
        long questionIndex;
        long answerIndex;
        long correctAnswerIndex;
        long positionIndex;
        long isCorrectIndex;

        AnswerColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Answer");
            this.questionIndex = addColumnDetails("question", "question", objectSchemaInfo);
            this.answerIndex = addColumnDetails("answer", "answer", objectSchemaInfo);
            this.correctAnswerIndex = addColumnDetails("correctAnswer", "correctAnswer", objectSchemaInfo);
            this.positionIndex = addColumnDetails("position", "position", objectSchemaInfo);
            this.isCorrectIndex = addColumnDetails("isCorrect", "isCorrect", objectSchemaInfo);
        }

        AnswerColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AnswerColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AnswerColumnInfo src = (AnswerColumnInfo) rawSrc;
            final AnswerColumnInfo dst = (AnswerColumnInfo) rawDst;
            dst.questionIndex = src.questionIndex;
            dst.answerIndex = src.answerIndex;
            dst.correctAnswerIndex = src.correctAnswerIndex;
            dst.positionIndex = src.positionIndex;
            dst.isCorrectIndex = src.isCorrectIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private AnswerColumnInfo columnInfo;
    private ProxyState<com.rensis.trivia.Model.Answer> proxyState;

    com_rensis_trivia_Model_AnswerRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AnswerColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rensis.trivia.Model.Answer>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$question() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.questionIndex);
    }

    @Override
    public void realmSet$question(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.questionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.questionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.questionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.questionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$answer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.answerIndex);
    }

    @Override
    public void realmSet$answer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.answerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.answerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.answerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.answerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$correctAnswer() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.correctAnswerIndex);
    }

    @Override
    public void realmSet$correctAnswer(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.correctAnswerIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.correctAnswerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.correctAnswerIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.correctAnswerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$position() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.positionIndex);
    }

    @Override
    public void realmSet$position(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.positionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.positionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isCorrect() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isCorrectIndex);
    }

    @Override
    public void realmSet$isCorrect(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isCorrectIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isCorrectIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Answer", 5, 0);
        builder.addPersistedProperty("question", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("answer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("correctAnswer", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("position", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("isCorrect", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static AnswerColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new AnswerColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Answer";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Answer";
    }

    @SuppressWarnings("cast")
    public static com.rensis.trivia.Model.Answer createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.rensis.trivia.Model.Answer obj = realm.createObjectInternal(com.rensis.trivia.Model.Answer.class, true, excludeFields);

        final com_rensis_trivia_Model_AnswerRealmProxyInterface objProxy = (com_rensis_trivia_Model_AnswerRealmProxyInterface) obj;
        if (json.has("question")) {
            if (json.isNull("question")) {
                objProxy.realmSet$question(null);
            } else {
                objProxy.realmSet$question((String) json.getString("question"));
            }
        }
        if (json.has("answer")) {
            if (json.isNull("answer")) {
                objProxy.realmSet$answer(null);
            } else {
                objProxy.realmSet$answer((String) json.getString("answer"));
            }
        }
        if (json.has("correctAnswer")) {
            if (json.isNull("correctAnswer")) {
                objProxy.realmSet$correctAnswer(null);
            } else {
                objProxy.realmSet$correctAnswer((String) json.getString("correctAnswer"));
            }
        }
        if (json.has("position")) {
            if (json.isNull("position")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
            } else {
                objProxy.realmSet$position((int) json.getInt("position"));
            }
        }
        if (json.has("isCorrect")) {
            if (json.isNull("isCorrect")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isCorrect' to null.");
            } else {
                objProxy.realmSet$isCorrect((boolean) json.getBoolean("isCorrect"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rensis.trivia.Model.Answer createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.rensis.trivia.Model.Answer obj = new com.rensis.trivia.Model.Answer();
        final com_rensis_trivia_Model_AnswerRealmProxyInterface objProxy = (com_rensis_trivia_Model_AnswerRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("question")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$question((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$question(null);
                }
            } else if (name.equals("answer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$answer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$answer(null);
                }
            } else if (name.equals("correctAnswer")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$correctAnswer((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$correctAnswer(null);
                }
            } else if (name.equals("position")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$position((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'position' to null.");
                }
            } else if (name.equals("isCorrect")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isCorrect((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isCorrect' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.rensis.trivia.Model.Answer copyOrUpdate(Realm realm, com.rensis.trivia.Model.Answer object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.rensis.trivia.Model.Answer) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.rensis.trivia.Model.Answer copy(Realm realm, com.rensis.trivia.Model.Answer newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rensis.trivia.Model.Answer) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.rensis.trivia.Model.Answer realmObject = realm.createObjectInternal(com.rensis.trivia.Model.Answer.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_rensis_trivia_Model_AnswerRealmProxyInterface realmObjectSource = (com_rensis_trivia_Model_AnswerRealmProxyInterface) newObject;
        com_rensis_trivia_Model_AnswerRealmProxyInterface realmObjectCopy = (com_rensis_trivia_Model_AnswerRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$question(realmObjectSource.realmGet$question());
        realmObjectCopy.realmSet$answer(realmObjectSource.realmGet$answer());
        realmObjectCopy.realmSet$correctAnswer(realmObjectSource.realmGet$correctAnswer());
        realmObjectCopy.realmSet$position(realmObjectSource.realmGet$position());
        realmObjectCopy.realmSet$isCorrect(realmObjectSource.realmGet$isCorrect());
        return realmObject;
    }

    public static long insert(Realm realm, com.rensis.trivia.Model.Answer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rensis.trivia.Model.Answer.class);
        long tableNativePtr = table.getNativePtr();
        AnswerColumnInfo columnInfo = (AnswerColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.Answer.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$question = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$question();
        if (realmGet$question != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
        }
        String realmGet$answer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$answer();
        if (realmGet$answer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
        }
        String realmGet$correctAnswer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$correctAnswer();
        if (realmGet$correctAnswer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.correctAnswerIndex, rowIndex, realmGet$correctAnswer, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$position(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCorrectIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$isCorrect(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rensis.trivia.Model.Answer.class);
        long tableNativePtr = table.getNativePtr();
        AnswerColumnInfo columnInfo = (AnswerColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.Answer.class);
        com.rensis.trivia.Model.Answer object = null;
        while (objects.hasNext()) {
            object = (com.rensis.trivia.Model.Answer) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$question = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$question();
            if (realmGet$question != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
            }
            String realmGet$answer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$answer();
            if (realmGet$answer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
            }
            String realmGet$correctAnswer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$correctAnswer();
            if (realmGet$correctAnswer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.correctAnswerIndex, rowIndex, realmGet$correctAnswer, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$position(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isCorrectIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$isCorrect(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.rensis.trivia.Model.Answer object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rensis.trivia.Model.Answer.class);
        long tableNativePtr = table.getNativePtr();
        AnswerColumnInfo columnInfo = (AnswerColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.Answer.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$question = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$question();
        if (realmGet$question != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.questionIndex, rowIndex, false);
        }
        String realmGet$answer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$answer();
        if (realmGet$answer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.answerIndex, rowIndex, false);
        }
        String realmGet$correctAnswer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$correctAnswer();
        if (realmGet$correctAnswer != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.correctAnswerIndex, rowIndex, realmGet$correctAnswer, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.correctAnswerIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$position(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isCorrectIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$isCorrect(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rensis.trivia.Model.Answer.class);
        long tableNativePtr = table.getNativePtr();
        AnswerColumnInfo columnInfo = (AnswerColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.Answer.class);
        com.rensis.trivia.Model.Answer object = null;
        while (objects.hasNext()) {
            object = (com.rensis.trivia.Model.Answer) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$question = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$question();
            if (realmGet$question != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.questionIndex, rowIndex, realmGet$question, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.questionIndex, rowIndex, false);
            }
            String realmGet$answer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$answer();
            if (realmGet$answer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.answerIndex, rowIndex, realmGet$answer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.answerIndex, rowIndex, false);
            }
            String realmGet$correctAnswer = ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$correctAnswer();
            if (realmGet$correctAnswer != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.correctAnswerIndex, rowIndex, realmGet$correctAnswer, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.correctAnswerIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.positionIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$position(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isCorrectIndex, rowIndex, ((com_rensis_trivia_Model_AnswerRealmProxyInterface) object).realmGet$isCorrect(), false);
        }
    }

    public static com.rensis.trivia.Model.Answer createDetachedCopy(com.rensis.trivia.Model.Answer realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rensis.trivia.Model.Answer unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rensis.trivia.Model.Answer();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rensis.trivia.Model.Answer) cachedObject.object;
            }
            unmanagedObject = (com.rensis.trivia.Model.Answer) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rensis_trivia_Model_AnswerRealmProxyInterface unmanagedCopy = (com_rensis_trivia_Model_AnswerRealmProxyInterface) unmanagedObject;
        com_rensis_trivia_Model_AnswerRealmProxyInterface realmSource = (com_rensis_trivia_Model_AnswerRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$question(realmSource.realmGet$question());
        unmanagedCopy.realmSet$answer(realmSource.realmGet$answer());
        unmanagedCopy.realmSet$correctAnswer(realmSource.realmGet$correctAnswer());
        unmanagedCopy.realmSet$position(realmSource.realmGet$position());
        unmanagedCopy.realmSet$isCorrect(realmSource.realmGet$isCorrect());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Answer = proxy[");
        stringBuilder.append("{question:");
        stringBuilder.append(realmGet$question() != null ? realmGet$question() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{answer:");
        stringBuilder.append(realmGet$answer() != null ? realmGet$answer() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{correctAnswer:");
        stringBuilder.append(realmGet$correctAnswer() != null ? realmGet$correctAnswer() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{position:");
        stringBuilder.append(realmGet$position());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isCorrect:");
        stringBuilder.append(realmGet$isCorrect());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_rensis_trivia_Model_AnswerRealmProxy aAnswer = (com_rensis_trivia_Model_AnswerRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAnswer.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAnswer.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAnswer.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

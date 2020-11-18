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
public class com_rensis_trivia_Model_SolvedQuestionsRealmProxy extends com.rensis.trivia.Model.SolvedQuestions
    implements RealmObjectProxy, com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface {

    static final class SolvedQuestionsColumnInfo extends ColumnInfo {
        long answersIndex;

        SolvedQuestionsColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("SolvedQuestions");
            this.answersIndex = addColumnDetails("answers", "answers", objectSchemaInfo);
        }

        SolvedQuestionsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SolvedQuestionsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SolvedQuestionsColumnInfo src = (SolvedQuestionsColumnInfo) rawSrc;
            final SolvedQuestionsColumnInfo dst = (SolvedQuestionsColumnInfo) rawDst;
            dst.answersIndex = src.answersIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private SolvedQuestionsColumnInfo columnInfo;
    private ProxyState<com.rensis.trivia.Model.SolvedQuestions> proxyState;
    private RealmList<com.rensis.trivia.Model.Answer> answersRealmList;

    com_rensis_trivia_Model_SolvedQuestionsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SolvedQuestionsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.rensis.trivia.Model.SolvedQuestions>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    public RealmList<com.rensis.trivia.Model.Answer> realmGet$answers() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (answersRealmList != null) {
            return answersRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.answersIndex);
            answersRealmList = new RealmList<com.rensis.trivia.Model.Answer>(com.rensis.trivia.Model.Answer.class, osList, proxyState.getRealm$realm());
            return answersRealmList;
        }
    }

    @Override
    public void realmSet$answers(RealmList<com.rensis.trivia.Model.Answer> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("answers")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.rensis.trivia.Model.Answer> original = value;
                value = new RealmList<com.rensis.trivia.Model.Answer>();
                for (com.rensis.trivia.Model.Answer item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.answersIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rensis.trivia.Model.Answer linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                com.rensis.trivia.Model.Answer linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("SolvedQuestions", 1, 0);
        builder.addPersistedLinkProperty("answers", RealmFieldType.LIST, "Answer");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SolvedQuestionsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SolvedQuestionsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "SolvedQuestions";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "SolvedQuestions";
    }

    @SuppressWarnings("cast")
    public static com.rensis.trivia.Model.SolvedQuestions createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("answers")) {
            excludeFields.add("answers");
        }
        com.rensis.trivia.Model.SolvedQuestions obj = realm.createObjectInternal(com.rensis.trivia.Model.SolvedQuestions.class, true, excludeFields);

        final com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface objProxy = (com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) obj;
        if (json.has("answers")) {
            if (json.isNull("answers")) {
                objProxy.realmSet$answers(null);
            } else {
                objProxy.realmGet$answers().clear();
                JSONArray array = json.getJSONArray("answers");
                for (int i = 0; i < array.length(); i++) {
                    com.rensis.trivia.Model.Answer item = com_rensis_trivia_Model_AnswerRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$answers().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.rensis.trivia.Model.SolvedQuestions createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.rensis.trivia.Model.SolvedQuestions obj = new com.rensis.trivia.Model.SolvedQuestions();
        final com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface objProxy = (com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("answers")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$answers(null);
                } else {
                    objProxy.realmSet$answers(new RealmList<com.rensis.trivia.Model.Answer>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.rensis.trivia.Model.Answer item = com_rensis_trivia_Model_AnswerRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$answers().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.rensis.trivia.Model.SolvedQuestions copyOrUpdate(Realm realm, com.rensis.trivia.Model.SolvedQuestions object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.rensis.trivia.Model.SolvedQuestions) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.rensis.trivia.Model.SolvedQuestions copy(Realm realm, com.rensis.trivia.Model.SolvedQuestions newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.rensis.trivia.Model.SolvedQuestions) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.rensis.trivia.Model.SolvedQuestions realmObject = realm.createObjectInternal(com.rensis.trivia.Model.SolvedQuestions.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface realmObjectSource = (com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) newObject;
        com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface realmObjectCopy = (com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) realmObject;


        RealmList<com.rensis.trivia.Model.Answer> answersList = realmObjectSource.realmGet$answers();
        if (answersList != null) {
            RealmList<com.rensis.trivia.Model.Answer> answersRealmList = realmObjectCopy.realmGet$answers();
            answersRealmList.clear();
            for (int i = 0; i < answersList.size(); i++) {
                com.rensis.trivia.Model.Answer answersItem = answersList.get(i);
                com.rensis.trivia.Model.Answer cacheanswers = (com.rensis.trivia.Model.Answer) cache.get(answersItem);
                if (cacheanswers != null) {
                    answersRealmList.add(cacheanswers);
                } else {
                    answersRealmList.add(com_rensis_trivia_Model_AnswerRealmProxy.copyOrUpdate(realm, answersItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, com.rensis.trivia.Model.SolvedQuestions object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rensis.trivia.Model.SolvedQuestions.class);
        long tableNativePtr = table.getNativePtr();
        SolvedQuestionsColumnInfo columnInfo = (SolvedQuestionsColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.SolvedQuestions.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);

        RealmList<com.rensis.trivia.Model.Answer> answersList = ((com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) object).realmGet$answers();
        if (answersList != null) {
            OsList answersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.answersIndex);
            for (com.rensis.trivia.Model.Answer answersItem : answersList) {
                Long cacheItemIndexanswers = cache.get(answersItem);
                if (cacheItemIndexanswers == null) {
                    cacheItemIndexanswers = com_rensis_trivia_Model_AnswerRealmProxy.insert(realm, answersItem, cache);
                }
                answersOsList.addRow(cacheItemIndexanswers);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rensis.trivia.Model.SolvedQuestions.class);
        long tableNativePtr = table.getNativePtr();
        SolvedQuestionsColumnInfo columnInfo = (SolvedQuestionsColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.SolvedQuestions.class);
        com.rensis.trivia.Model.SolvedQuestions object = null;
        while (objects.hasNext()) {
            object = (com.rensis.trivia.Model.SolvedQuestions) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);

            RealmList<com.rensis.trivia.Model.Answer> answersList = ((com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) object).realmGet$answers();
            if (answersList != null) {
                OsList answersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.answersIndex);
                for (com.rensis.trivia.Model.Answer answersItem : answersList) {
                    Long cacheItemIndexanswers = cache.get(answersItem);
                    if (cacheItemIndexanswers == null) {
                        cacheItemIndexanswers = com_rensis_trivia_Model_AnswerRealmProxy.insert(realm, answersItem, cache);
                    }
                    answersOsList.addRow(cacheItemIndexanswers);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.rensis.trivia.Model.SolvedQuestions object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.rensis.trivia.Model.SolvedQuestions.class);
        long tableNativePtr = table.getNativePtr();
        SolvedQuestionsColumnInfo columnInfo = (SolvedQuestionsColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.SolvedQuestions.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);

        OsList answersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.answersIndex);
        RealmList<com.rensis.trivia.Model.Answer> answersList = ((com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) object).realmGet$answers();
        if (answersList != null && answersList.size() == answersOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = answersList.size();
            for (int i = 0; i < objects; i++) {
                com.rensis.trivia.Model.Answer answersItem = answersList.get(i);
                Long cacheItemIndexanswers = cache.get(answersItem);
                if (cacheItemIndexanswers == null) {
                    cacheItemIndexanswers = com_rensis_trivia_Model_AnswerRealmProxy.insertOrUpdate(realm, answersItem, cache);
                }
                answersOsList.setRow(i, cacheItemIndexanswers);
            }
        } else {
            answersOsList.removeAll();
            if (answersList != null) {
                for (com.rensis.trivia.Model.Answer answersItem : answersList) {
                    Long cacheItemIndexanswers = cache.get(answersItem);
                    if (cacheItemIndexanswers == null) {
                        cacheItemIndexanswers = com_rensis_trivia_Model_AnswerRealmProxy.insertOrUpdate(realm, answersItem, cache);
                    }
                    answersOsList.addRow(cacheItemIndexanswers);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.rensis.trivia.Model.SolvedQuestions.class);
        long tableNativePtr = table.getNativePtr();
        SolvedQuestionsColumnInfo columnInfo = (SolvedQuestionsColumnInfo) realm.getSchema().getColumnInfo(com.rensis.trivia.Model.SolvedQuestions.class);
        com.rensis.trivia.Model.SolvedQuestions object = null;
        while (objects.hasNext()) {
            object = (com.rensis.trivia.Model.SolvedQuestions) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);

            OsList answersOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.answersIndex);
            RealmList<com.rensis.trivia.Model.Answer> answersList = ((com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) object).realmGet$answers();
            if (answersList != null && answersList.size() == answersOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = answersList.size();
                for (int i = 0; i < objectCount; i++) {
                    com.rensis.trivia.Model.Answer answersItem = answersList.get(i);
                    Long cacheItemIndexanswers = cache.get(answersItem);
                    if (cacheItemIndexanswers == null) {
                        cacheItemIndexanswers = com_rensis_trivia_Model_AnswerRealmProxy.insertOrUpdate(realm, answersItem, cache);
                    }
                    answersOsList.setRow(i, cacheItemIndexanswers);
                }
            } else {
                answersOsList.removeAll();
                if (answersList != null) {
                    for (com.rensis.trivia.Model.Answer answersItem : answersList) {
                        Long cacheItemIndexanswers = cache.get(answersItem);
                        if (cacheItemIndexanswers == null) {
                            cacheItemIndexanswers = com_rensis_trivia_Model_AnswerRealmProxy.insertOrUpdate(realm, answersItem, cache);
                        }
                        answersOsList.addRow(cacheItemIndexanswers);
                    }
                }
            }

        }
    }

    public static com.rensis.trivia.Model.SolvedQuestions createDetachedCopy(com.rensis.trivia.Model.SolvedQuestions realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.rensis.trivia.Model.SolvedQuestions unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.rensis.trivia.Model.SolvedQuestions();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.rensis.trivia.Model.SolvedQuestions) cachedObject.object;
            }
            unmanagedObject = (com.rensis.trivia.Model.SolvedQuestions) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface unmanagedCopy = (com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) unmanagedObject;
        com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface realmSource = (com_rensis_trivia_Model_SolvedQuestionsRealmProxyInterface) realmObject;

        // Deep copy of answers
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$answers(null);
        } else {
            RealmList<com.rensis.trivia.Model.Answer> managedanswersList = realmSource.realmGet$answers();
            RealmList<com.rensis.trivia.Model.Answer> unmanagedanswersList = new RealmList<com.rensis.trivia.Model.Answer>();
            unmanagedCopy.realmSet$answers(unmanagedanswersList);
            int nextDepth = currentDepth + 1;
            int size = managedanswersList.size();
            for (int i = 0; i < size; i++) {
                com.rensis.trivia.Model.Answer item = com_rensis_trivia_Model_AnswerRealmProxy.createDetachedCopy(managedanswersList.get(i), nextDepth, maxDepth, cache);
                unmanagedanswersList.add(item);
            }
        }

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SolvedQuestions = proxy[");
        stringBuilder.append("{answers:");
        stringBuilder.append("RealmList<Answer>[").append(realmGet$answers().size()).append("]");
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
        com_rensis_trivia_Model_SolvedQuestionsRealmProxy aSolvedQuestions = (com_rensis_trivia_Model_SolvedQuestionsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSolvedQuestions.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSolvedQuestions.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSolvedQuestions.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}

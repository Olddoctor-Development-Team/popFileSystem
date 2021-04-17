#include <unistd.h>
#include <cstdlib>
#include <sys/inotify.h>
#include <string.h>
#include "net_olddoctor_popFilesystem_daemon_lib_FileWatcher.h"

#ifndef _BUFF_SIZE
#define _BUFF_SIZE 64
#endif

char* jstringToChar(JNIEnv* env, jstring jstr);

JNIEXPORT jint JNICALL Java_net_olddoctor_popFilesystem_daemon_lib_FileWatcher_createFileWatcherNative
  (JNIEnv *, jobject) {
  return inotify_init();
}

JNIEXPORT jint JNICALL Java_net_olddoctor_popFilesystem_daemon_lib_FileWatcher_addFolderNative
  (JNIEnv *env, jobject, jstring folder, jint watcher) {
  return inotify_add_watch(watcher, jstringToChar(env, folder), IN_ALL_EVENTS);
}

JNIEXPORT jint JNICALL Java_net_olddoctor_popFilesystem_daemon_lib_FileWatcher_rmFolderNative
  (JNIEnv *env, jobject, jint wd, jint watcher) {
  return inotify_rm_watch(watcher, wd);
}

JNIEXPORT jint JNICALL Java_net_olddoctor_popFilesystem_daemon_lib_FileWatcher_getEventNative
  (JNIEnv *, jobject, jint watcher) {
    

}

char* jstringToChar(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("GB2312");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray) env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char*) malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    return rtn;
}
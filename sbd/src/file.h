#ifndef FILE_H
#define FILE_H

#include "record.h"

struct file {
    int num_records;
    int num_overflow_records;

    struct record *records;
    struct record *overflow;

    void *ov_start;
};

void file_init(struct file* file);
int file_append_record(struct file *file, struct record *record);
int file_import( struct file *file, const char* import_path);
int file_print(struct file *file);

#endif // FILE_H

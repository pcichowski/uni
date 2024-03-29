#ifndef BTREE_H
#define BTREE_H

struct file;

#include "page.h"
#include "record.h"

struct btree {

    int order;
    int height;
    int num_pages;

    struct page root;
};

int btree_init(struct file *file, const char *path, const char *data_path, int tree_order);
int btree_open(struct file *file, const char *path, const char *data_path);

int btree_search(struct file *file, int key, int *page_index, int *element_index);
int btree_insert_record(struct file *file, struct record *record);

#endif // BTREE_H

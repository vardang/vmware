/**
 * Created by vardang on 2/20/17.
 */

Ext.Loader.setConfig({
    enabled: true,
    disableCaching: false
});
Ext.define('Book', {
    extend: 'Ext.data.Model',
    proxy: {
        type: 'ajax',
        url: 'http://localhost:8080/Task3/book/getBooks',
        reader: {
            type: 'json'
        }
    },
    folderSort: true,
    rootVisible: false

});

var store = Ext.create('Ext.data.TreeStore', {
    model: 'Book',
    root: {
        name: 'Book',
        expanded: true
    }
});

var tree = Ext.create('Ext.tree.Panel', {
    width: 300,
    title: 'Book',
    store: store,
    columns: [{
        xtype: 'treecolumn',
        header: 'Name',
        dataIndex: 'name',
        flex: 1
    }]
});
Ext.onReady(function () {


    Ext.create('Ext.container.Viewport', {
        renderTo: document.body,
        layout: 'border',
        items: [tree,  {
            region: 'east',
            items: {
                title: 'My Favorite Books',
                html: 'The first tab\'s content. Others may be added dynamically'
            }
        }]
    });

});
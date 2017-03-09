Ext.define('Person', {
extend: 'Ext.data.Model',
fields: [
{ name: 'id', type: 'int' },
{ name: 'name', type: 'string' }
],
proxy: {
type: 'jsonp',
api: {
    create: 'createPersons',
    read: 'http://localhost:4567/books',
    update: 'updatePersons',
    destroy: 'destroyPersons'
}
}

});

var store = Ext.create('Ext.data.TreeStore', {
model: 'Person',
root: {
    name: 'People',
    expanded: true
}
});

Ext.create('Ext.tree.Panel', {
renderTo: document.body,
width: 300,
height: 200,
title: 'People',
store: store,
columns: [{
    xtype: 'treecolumn',
    header: 'Name',
    dataIndex: 'name',
    flex: 1
}]
});
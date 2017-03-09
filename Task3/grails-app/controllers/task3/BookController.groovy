package task3

import grails.transaction.Transactional
import groovy.json.JsonSlurper
@Transactional(readOnly = true)
class BookController {


    static allowedMethods = [getBooks: "GET"]

    def index() {
        render view: 'index'
    }

    def getBooks() {
        String jsonString = 'Ext.data.JsonP.callback1([{"id":"1","name":"Accounting","numEmployees":"45","text":"Accounting"},{"id":"2","name":"Advertising","numEmployees":"30","text":"Advertising"},{"id":"3","name":"Asset Management","numEmployees":"35","text":"Asset Management"},{"id":"4","name":"Customer Relations","numEmployees":"28","text":"Customer Relations"},{"id":"5","name":"Customer Service","numEmployees":"42","text":"Customer Service"},{"id":"6","name":"Finances","numEmployees":"33","text":"Finances"},{"id":"7","name":"Human Resources","numEmployees":"34","text":"Human Resources"},{"id":"8","name":"Legal Department","numEmployees":"38","text":"Legal Department"},{"id":"9","name":"Media Relations","numEmployees":"37","text":"Media Relations"},{"id":"10","name":"Payroll","numEmployees":"35","text":"Payroll"},{"id":"11","name":"Public Relations","numEmployees":"41","text":"Public Relations"},{"id":"12","name":"Quality Assurance","numEmployees":"39","text":"Quality Assurance"},{"id":"14","name":"Research and Development","numEmployees":"26","text":"Research and Development"},{"id":"13","name":"Sales and Marketing","numEmployees":"34","text":"Sales and Marketing"},{"id":"15","name":"Tech Support","numEmployees":"38","text":"Tech Support"}]);'
        JsonSlurper jsonSlurper = new JsonSlurper()
        render jsonString
    }
}

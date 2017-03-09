class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/rest/book/root" {
            controller = 'book'
            action = 'getBooks'
            constraints {
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}

(defproject guake-project "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.cli "0.3.3"]]
  
  :main ^:skip-aot guake-project.core
  
  :plugins [[lein-bin "0.3.5"]]
  :bin {:name "guake-project"
      	:bin-path "./target"}
  
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

(ns guake-project.core
  (:require [clojure.tools.cli :as cli]))

(defn create-project 
  [name]
  (print name))

(defn update-project 
  []
  (print name))

(defn open-project
  [name]
  (print name))

(defn list-projects []
  (print "list"))

(def options
  ;; An option with a required argument
  [["-c" "--create PROJECT_NAME" "Create project"
    :parse-fn create-project]
   ["-c" "--update" "Update project"
    :parse-fn update-project]
   ["-o" "--open PROJECT_NAME" "Open project"
    :parse-fn open-project]
   ["-l" "--list" "List all projects"]
    :parse-fn list-projects])

(defn -main [& args]
  (cli/parse-opts args options))


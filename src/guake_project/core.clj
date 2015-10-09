(ns guake-project.core
  (:require [clojure.tools.cli :as cli]))

(defn read-property
  [question]
  (print (str question))
  (flush)
  (read-line))

(defn read-tabs
  []
  (let [tabs []]
  (defn new-tab []
    (read-property "Tab title (optional): "))
  (conj tabs (new-tab))))

(defn create-project
  [project-name]
  (let [project
        {:name project-name
         :base-dir (read-property "Base Directory: ")
         :project-tabs (read-tabs)}]
    (println (str project))))

(defn update-project 
  [name]
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
   ["-u" "--update" "Update project"
    :parse-fn update-project]
   ["-o" "--open PROJECT_NAME" "Open project"
    :parse-fn open-project]
   ["-l" "--list" "List all projects"
    :parse-fn list-projects]])

(defn -main [& args]
  (cli/parse-opts args options))


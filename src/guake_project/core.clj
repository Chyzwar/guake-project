(ns guake-project.core
  (:require [clojure.tools.cli :as cli]))

(defn read-input
  "read input from stdin"
  [question]
  (print (str question))
  (flush)
  (read-line))

(defn read-commands
  []
  (println "Provide list of commands to be excecuted (optional)")
  (let [commands (atom [])]
    (def is-enough (atom false))
    
    (while (false? @is-enough)
      (do
        (swap! commands conj (read-input "command: "))
        (if (= "no" (read-input "Additional command (yes/no) "))
          (swap! is-enough true))))
    
    (print @commands)
    (@commands)))

(defn read-tabs
  []
  (let [tabs (atom [])]
    (defn new-tab []
      ({:tab-title (read-input "Tab title (optional): ")
        :tab-path-affix (read-input "Additional path affix(optional) ")
        :commands-seq (read-commands)}))
    
    (swap! tabs conj (new-tab))
    (print tabs)))

(defn create-project
  [project-name]
  (let [project
        {:name project-name
         :base-dir (read-input "Base Directory path: ")
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


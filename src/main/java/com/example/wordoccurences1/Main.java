package com.example.wordoccurences1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Main extends Application {
    private TextArea outputTextArea;

    /**
     * Analyzes text provided by the url and outputs the frequency
     * of said text in a textArea, upon clicking the analyze button
     * implemented the in program.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This class creates the textArea where the word frequency is displayed.
     * Creates the button to trigger the analysis.
     * Defines the root layout.
     * Implements a junit test case to test the expected result of the analysis.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Analyzer");

        // Create the TextArea to display the output
        outputTextArea = new TextArea();
        outputTextArea.setPrefSize(400, 350);
        outputTextArea.setEditable(false);

        // Create the Button to trigger the text analysis
        Button analyzeButton = new Button("Analyze");
        analyzeButton.setOnAction(event -> analyzeText("the: 236\n" + "of: 140\n" + "and: 102\n" + "to: 87\n" + "project: 86\n" + "or: 82\n" + "a: 73\n" + "you: 73\n" + "in: 65\n" + "this: 60\n" + "gutenberg&#8482: 57\n" + "with: 53\n" + "1: 45\n" + "work: 45\n" + "any: 37\n" + "by: 33\n" + "is: 33\n" + "that: 33\n" + "i: 32\n" + "works: 32\n" + "gutenberg: 31\n" + "not: 30\n" + "for: 29\n" + "”: 27\n" + "electronic: 27\n" + "if: 25\n" + "my: 24\n" + "e: 23\n" + "from: 23\n" + "all: 21\n" + "are: 21\n" + "on: 21\n" + "terms: 21\n" + "foundation: 21\n" + "at: 20\n" + "be: 20\n" + "copyright: 19\n" + "agreement: 18\n" + "do: 17\n" + "states: 17\n" + "it: 17\n" + "other: 16\n" + "as: 16\n" + "license: 16\n" + "may: 15\n" + "no: 15\n" + "donations: 15\n" + "s: 13\n" + "united: 13\n" + "full: 13\n" + "trademark: 13\n" + "archive: 13\n" + "literary: 13\n" + "raven: 12\n" + "use: 12\n" + "f: 11\n" + "paragraph: 11\n" + "&#8220: 11\n" + "but: 11\n" + "we: 11\n" + "copy: 11\n" + "chamber: 11\n" + "your: 10\n" + "3: 10\n" + "must: 10\n" + "bird: 10\n" + "access: 10\n" + "can: 10\n" + "there: 9\n" + "have: 9\n" + "including: 9\n" + "was: 9\n" + "laws: 9\n" + "more: 9\n" + "he: 9\n" + "ebook: 9\n" + "agree: 9\n" + "refund: 9\n" + "without: 8\n" + "information: 8\n" + "forth: 8\n" + "“nevermore: 8\n" + "door: 8\n" + "fee: 8\n" + "an: 8\n" + "set: 8\n" + "which: 8\n" + "www: 8\n" + "about: 8\n" + "then: 8\n" + "will: 8\n" + "u: 7\n" + "ebooks: 7\n" + "its: 7\n" + "nothing: 7\n" + "upon: 7\n" + "copies: 7\n" + "law: 7\n" + "such: 7\n" + "provide: 7\n" + "before: 7\n" + "section: 7\n" + "me: 7\n" + "soul: 7\n" + "above: 7\n" + "&mdash: 7\n" + "associated: 7\n" + "still: 7\n" + "distributing: 7\n" + "said: 7\n" + "thy: 6\n" + "bust: 6\n" + "distribute: 6\n" + "name: 6\n" + "paid: 6\n" + "his: 6\n" + "comply: 6\n" + "charge: 6\n" + "some: 6\n" + "door&mdash: 6\n" + "permission: 6\n" + "within: 6\n" + "into: 6\n" + "so: 6\n" + "one: 6\n" + "word: 6\n" + "distribution: 6\n" + "only: 6\n" + "tax: 6\n" + "quoth: 5\n" + "protected: 5\n" + "volunteers: 5\n" + "4: 5\n" + "days: 5\n" + "medium: 5\n" + "shall: 5\n" + "state: 5\n" + "using: 5\n" + "what: 5\n" + "tell: 5\n" + "whom: 5\n" + "under: 5\n" + "form: 5\n" + "than: 5\n" + "received: 5\n" + "free: 5\n" + "gutenberg&#8221: 5\n" + "our: 5\n" + "cannot: 5\n" + "located: 5\n" + "replacement: 5\n" + "limited: 5\n" + "compliance: 5\n" + "these: 4\n" + "8: 4\n" + "providing: 4\n" + "posted: 4\n" + "website: 4\n" + "c: 4\n" + "copying: 4\n" + "provided: 4\n" + "distributed: 4\n" + "floor: 4\n" + "creating: 4\n" + "where: 4\n" + "holder: 4\n" + "angels: 4\n" + "tapping: 4\n" + "format: 4\n" + "most: 4\n" + "phrase: 4\n" + "part: 4\n" + "requirements: 4\n" + "how: 4\n" + "see: 4\n" + "right: 4\n" + "&bull: 4\n" + "freely: 4\n" + "owner: 4\n" + "status: 4\n" + "fees: 4\n" + "editions: 4\n" + "mission: 4\n" + "except: 4\n" + "many: 4\n" + "displaying: 4\n" + "collection: 4\n" + "support: 4\n" + "org: 4\n" + "anyone: 4\n" + "following: 4\n" + "damages: 4\n" + "help: 4\n" + "individual: 4\n" + "person: 4\n" + "here: 4\n" + "2: 3\n" + "5: 3\n" + "7: 3\n" + "9: 3\n" + "official: 3\n" + "leave: 3\n" + "check: 3\n" + "visiter: 3\n" + "royalties: 3\n" + "number: 3\n" + "defect: 3\n" + "future: 3\n" + "entity: 3\n" + "defective: 3\n" + "links: 3\n" + "new: 3\n" + "read: 3\n" + "below: 3\n" + "liability: 3\n" + "applicable: 3\n" + "nevermore: 3\n" + "performing: 3\n" + "perched: 3\n" + "lamp: 3\n" + "complying: 3\n" + "velvet: 3\n" + "spoken: 3\n" + "each: 3\n" + "warranties: 3\n" + "came: 3\n" + "till: 3\n" + "lenore&mdash: 3\n" + "paying: 3\n" + "has: 3\n" + "donate: 3\n" + "nearly: 3\n" + "fancy: 3\n" + "give: 3\n" + "light: 3\n" + "means: 3\n" + "rapping: 3\n" + "used: 3\n" + "obtain: 3\n" + "who: 3\n" + "limitation: 3\n" + "general: 3\n" + "sad: 3\n" + "sat: 3\n" + "user: 3\n" + "whose: 3\n" + "disclaimer: 3\n" + "contact: 3\n" + "additional: 3\n" + "back: 3\n" + "notice: 3\n" + "royalty: 3\n" + "paragraphs: 3\n" + "maiden: 3\n" + "payments: 3\n" + "return: 3\n" + "while: 3\n" + "foundation&#8217: 3\n" + "equipment: 3\n" + "heart: 3\n" + "make: 3\n" + "online: 3\n" + "sitting: 3\n" + "thee: 3\n" + "unless: 3\n" + "people: 3\n" + "country: 3\n" + "up: 3\n" + "written: 3\n" + "lenore: 3\n" + "please: 3\n" + "derivative: 3\n" + "money: 3\n" + "o’er: 3\n" + "out: 3\n" + "writing: 3\n" + "sent: 3\n" + "efforts: 3\n" + "public: 3\n" + "prepare: 2\n" + "“surely: 2\n" + "references: 2\n" + "redistribution: 2\n" + "explanation: 2\n" + "contributions: 2\n" + "electronically: 2\n" + "redistributing: 2\n" + "6: 2\n" + "much: 2\n" + "computers: 2\n" + "b: 2\n" + "god: 2\n" + "morrow: 2\n" + "dreaming: 2\n" + "obtaining: 2\n" + "flown: 2\n" + "ghastly: 2\n" + "exempt: 2\n" + "property: 2\n" + "darkness: 2\n" + "hath: 2\n" + "ever: 2\n" + "even: 2\n" + "plutonian: 2\n" + "intellectual: 2\n" + "removed: 2\n" + "copied: 2\n" + "whether: 2\n" + "owns: 2\n" + "entrance: 2\n" + "evil: 2\n" + "cause: 2\n" + "followed: 2\n" + "lining: 2\n" + "implore: 2\n" + "let: 2\n" + "mystery: 2\n" + "gently: 2\n" + "beguiling: 2\n" + "devil: 2\n" + "found: 2\n" + "permitted: 2\n" + "does: 2\n" + "stillness: 2\n" + "receive: 2\n" + "implied: 2\n" + "night’s: 2\n" + "through: 2\n" + "research: 2\n" + "things: 2\n" + "receipt: 2\n" + "page: 2\n" + "away: 2\n" + "concept: 2\n" + "edition: 2\n" + "effort: 2\n" + "anything: 2\n" + "now: 2\n" + "napping: 2\n" + "shore: 2\n" + "start: 2\n" + "yet: 2\n" + "***: 2\n" + "grew: 2\n" + "way: 2\n" + "when: 2\n" + "“’tis: 2\n" + "truly: 2\n" + "destroy: 2\n" + "damage: 2\n" + "computer: 2\n" + "nepenthe: 2\n" + "protect: 2\n" + "bore: 2\n" + "certain: 2\n" + "grim: 2\n" + "small: 2\n" + "pallas: 2\n" + "marked: 2\n" + "kind: 2\n" + "created: 2\n" + "particular: 2\n" + "both: 2\n" + "outside: 2\n" + "keep: 2\n" + "radiant: 2\n" + "breach: 2\n" + "also: 2\n" + "visit: 2\n" + "me&mdash: 2\n" + "promoting: 2\n" + "sure: 2\n" + "ah: 2\n" + "active: 2\n" + "domain: 2\n" + "eyes: 2\n" + "contain: 2\n" + "keeping: 2\n" + "rare: 2\n" + "legal: 2\n" + "muttered: 2\n" + "never: 2\n" + "take: 2\n" + "immediate: 2\n" + "little: 2\n" + "burden: 2\n" + "clasp: 2\n" + "just: 2\n" + "bound: 2\n" + "hope: 2\n" + "warranty: 2\n" + "sentence: 2\n" + "unbroken: 2\n" + "printed: 2\n" + "ascii&#8221: 2\n" + "prophet: 2\n" + "viewed: 2\n" + "“lenore: 2\n" + "fowl: 2\n" + "widest: 2\n" + "second: 2\n" + "considerable: 2\n" + "physical: 2\n" + "included: 2\n" + "heard: 2\n" + "hear: 2\n" + "entreating: 2\n" + "concerning: 2\n" + "stood: 2\n" + "registered: 2\n" + "sorrow: 2\n" + "they: 2\n" + "based: 2\n" + "old: 2\n" + "&#8221: 2\n" + "something: 2\n" + "long: 2\n" + "quaff: 2\n" + "email: 2\n" + "accordance: 2\n" + "generations: 2\n" + "available: 2\n" + "vanilla: 2\n" + "smiling: 2\n" + "org/donate: 2\n" + "lieu: 2\n" + "“prophet: 2\n" + "ungainly: 2\n" + "lost: 2\n" + "90: 2\n" + "ominous: 2\n" + "“thing: 2\n" + "specified: 2\n" + "federal: 2\n" + "prominently: 2\n" + "token: 2\n" + "date: 2\n" + "plain: 2\n" + "readable: 2\n" + "accepted: 2\n" + "solicit: 2\n" + "files: 2\n" + "expenses: 2\n" + "purpose: 2\n" + "tempest: 2\n" + "costs: 2\n" + "cost: 2\n" + "whispered: 2\n" + "yore: 2\n" + "spoke: 1\n" + "govern: 1\n" + "croaking: 1\n" + "tinkled: 1\n" + "silence: 1\n" + "calculate: 1\n" + "because: 1\n" + "whatsoever: 1\n" + "thus: 1\n" + "require: 1\n" + "version: 1\n" + "charges: 1\n" + "flirt: 1\n" + "801: 1\n" + "returns: 1\n" + "gutenberg’s: 1\n" + "wind: 1\n" + "809: 1\n" + "accessible: 1\n" + "least: 1\n" + "ein: 1\n" + "elect: 1\n" + "“what: 1\n" + "nightly: 1\n" + "same: 1\n" + "prohibition: 1\n" + "agreed: 1\n" + "linked: 1\n" + "committed: 1\n" + "address: 1\n" + "salt: 1\n" + "licensed: 1\n" + "d: 1\n" + "learn: 1\n" + "laden: 1\n" + "dreary: 1\n" + "irs: 1\n" + "distributor: 1\n" + "straight: 1\n" + "fast: 1\n" + "vainly: 1\n" + "reports: 1\n" + "murmured: 1\n" + "bosom’s: 1\n" + "agreeing: 1\n" + "wish: 1\n" + "negligence: 1\n" + "fitness: 1\n" + "repeating: 1\n" + "one&#8212: 1\n" + "adore&mdash: 1\n" + "others: 1\n" + "explore&mdash: 1\n" + "educational: 1\n" + "need: 1\n" + "pay: 1\n" + "often: 1\n" + "volume: 1\n" + "owed: 1\n" + "sinking: 1\n" + "loose: 1\n" + "formats: 1\n" + "production: 1\n" + "obsolete: 1\n" + "choose: 1\n" + "hart: 1\n" + "lent: 1\n" + "remove: 1\n" + "prevent: 1\n" + "disclaimers: 1\n" + "end: 1\n" + "ensuring: 1\n" + "forty: 1\n" + "there&mdash: 1\n" + "identify: 1\n" + "perform: 1\n" + "special: 1\n" + "service: 1\n" + "lady: 1\n" + "refund&#8221: 1\n" + "surcease: 1\n" + "accessed: 1\n" + "approach: 1\n" + "years: 1\n" + "fearing: 1\n" + "relevancy: 1\n" + "distant: 1\n" + "upstarting&mdash: 1\n" + "corporation: 1\n" + "understand: 1\n" + "confirmation: 1\n" + "tempter: 1\n" + "6221541: 1\n" + "heaven: 1\n" + "unhappy: 1\n" + "illustrated: 1\n" + "binary: 1\n" + "defects: 1\n" + "shadows: 1\n" + "appearing: 1\n" + "engaged: 1\n" + "city: 1\n" + "against: 1\n" + "exclusion: 1\n" + "air: 1\n" + "representations: 1\n" + "sorrow&mdash: 1\n" + "indicating: 1\n" + "decorum: 1\n" + "hypertext: 1\n" + "denser: 1\n" + "shaven: 1\n" + "“other: 1\n" + "betook: 1\n" + "share: 1\n" + "unsolicited: 1\n" + "particularly: 1\n" + "additions: 1\n" + "filled: 1\n" + "opportunities: 1\n" + "produce: 1\n" + "walks: 1\n" + "stored: 1\n" + "mississippi: 1\n" + "org/contact: 1\n" + "imposed: 1\n" + "almost: 1\n" + "indemnity: 1\n" + "employee: 1\n" + "“tapping: 1\n" + "pages: 1\n" + "west: 1\n" + "modified: 1\n" + "stock: 1\n" + "void: 1\n" + "already: 1\n" + "20%: 1\n" + "remedies: 1\n" + "expense: 1\n" + "maintaining: 1\n" + "sainted: 1\n" + "bore&mdash: 1\n" + "lake: 1\n" + "unenforceability: 1\n" + "financial: 1\n" + "dreams: 1\n" + "reaching: 1\n" + "land: 1\n" + "“sir: 1\n" + "possibility: 1\n" + "reclining: 1\n" + "louder: 1\n" + "stepped: 1\n" + "despite: 1\n" + "minute: 1\n" + "burning: 1\n" + "merchantability: 1\n" + "compilation: 1\n" + "fantastic: 1\n" + "renamed: 1\n" + "caught: 1\n" + "farther: 1\n" + "echo: 1\n" + "‘never&mdash: 1\n" + "anywhere: 1\n" + "incidental: 1\n" + "uncertain: 1\n" + "identification: 1\n" + "before&mdash: 1\n" + "perfumed: 1\n" + "liable: 1\n" + "press: 1\n" + "displayed: 1\n" + "containing: 1\n" + "remain: 1\n" + "forgiveness: 1\n" + "mortals: 1\n" + "countries: 1\n" + "demand: 1\n" + "000: 1\n" + "poe: 1\n" + "doubting: 1\n" + "moment: 1\n" + "cried: 1\n" + "reported: 1\n" + "indemnify: 1\n" + "takes: 1\n" + "“art: 1\n" + "creation: 1\n" + "broken: 1\n" + "pglaf: 1\n" + "horror: 1\n" + "beating: 1\n" + "black: 1\n" + "stayed: 1\n" + "purple: 1\n" + "quit: 1\n" + "countenance: 1\n" + "presently: 1\n" + "swung: 1\n" + "lie: 1\n" + "had: 1\n" + "secure: 1\n" + "either: 1\n" + "incomplete: 1\n" + "dying: 1\n" + "late: 1\n" + "donation: 1\n" + "those: 1\n" + "seeming: 1\n" + "offers: 1\n" + "given: 1\n" + "actual: 1\n" + "sharing: 1\n" + "longer: 1\n" + "flutter: 1\n" + "checks: 1\n" + "volunteer: 1\n" + "employees: 1\n" + "updated: 1\n" + "meaning&mdash: 1\n" + "originator: 1\n" + "non: 1\n" + "disaster: 1\n" + "stronger: 1\n" + "faintly: 1\n" + "derived: 1\n" + "early: 1\n" + "unto: 1\n" + "suddenly: 1\n" + "discourse: 1\n" + "shorn: 1\n" + "window: 1\n" + "shadow: 1\n" + "wheeled: 1\n" + "dirges: 1\n" + "taxes: 1\n" + "punitive: 1\n" + "plume: 1\n" + "required: 1\n" + "synonymous: 1\n" + "nameless: 1\n" + "lonely: 1\n" + "’”: 1\n" + "is&#8217: 1\n" + "ember: 1\n" + "depends: 1\n" + "violet: 1\n" + "consequential: 1\n" + "1500: 1\n" + "marvelled: 1\n" + "card: 1\n" + "redistribute: 1\n" + "methods: 1\n" + "direct: 1\n" + "paperwork: 1\n" + "confirmed: 1\n" + "burned: 1\n" + "lot: 1\n" + "madam: 1\n" + "receiving: 1\n" + "bleak: 1\n" + "ways: 1\n" + "gloating: 1\n" + "web: 1\n" + "memories: 1\n" + "dared: 1\n" + "merely: 1\n" + "quaint: 1\n" + "meant: 1\n" + "#45484: 1\n" + "survive: 1\n" + "explore: 1\n" + "display: 1\n" + "performed: 1\n" + "inaccurate: 1\n" + "mien: 1\n" + "songs: 1\n" + "permanent: 1\n" + "organized: 1\n" + "’tis: 1\n" + "facility: 1\n" + "cushioned: 1\n" + "beak: 1\n" + "possession: 1\n" + "replace: 1\n" + "silken: 1\n" + "unmerciful: 1\n" + "him: 1\n" + "wondering: 1\n" + "few: 1\n" + "proofread: 1\n" + "group: 1\n" + "described: 1\n" + "respite: 1\n" + "gross: 1\n" + "opened: 1\n" + "produced: 1\n" + "important: 1\n" + "parting: 1\n" + "ease: 1\n" + "request: 1\n" + "critical: 1\n" + "solicitation: 1\n" + "necessarily: 1\n" + "alone: 1\n" + "profit: 1\n" + "original: 1\n" + "subscribe: 1\n" + "craven: 1\n" + "”&mdash: 1\n" + "terrors: 1\n" + "front: 1\n" + "further: 1\n" + "extent: 1\n" + "allan: 1\n" + "fiery: 1\n" + "gloated: 1\n" + "viewing: 1\n" + "fix: 1\n" + "startled: 1\n" + "strict: 1\n" + "addition: 1\n" + "accepting: 1\n" + "disclaim: 1\n" + "opportunity: 1\n" + "s/he: 1\n" + "easy: 1\n" + "violates: 1\n" + "turning: 1\n" + "gaunt: 1\n" + "pondered: 1\n" + "flitting: 1\n" + "treatment: 1\n" + "hesitating: 1\n" + "virus: 1\n" + "search: 1\n" + "thrilled: 1\n" + "indicate: 1\n" + "scarcely: 1\n" + "foot: 1\n" + "nodded: 1\n" + "business: 1\n" + "shutter: 1\n" + "edgar: 1\n" + "alternate: 1\n" + "staff: 1\n" + "“thy: 1\n" + "answer: 1\n" + "meet: 1\n" + "borrow: 1\n" + "maximum: 1\n" + "desert: 1\n" + "did: 1\n" + "“doubtless: 1\n" + "$1: 1\n" + "hold: 1\n" + "$5: 1\n" + "outdated: 1\n" + "methought: 1\n" + "forgotten: 1\n" + "reply: 1\n" + "“though: 1\n" + "pallid: 1\n" + "you”&mdash: 1\n" + "ashore: 1\n" + "2001: 1\n" + "she: 1\n" + "parts: 1\n" + "carry: 1\n" + "gratefully: 1\n" + "party: 1\n" + "however: 1\n" + "deep: 1\n" + "beginning: 1\n" + "deletions: 1\n" + "loneliness: 1\n" + "title: 1\n" + "human: 1\n" + "cushion’s: 1\n" + "over: 1\n" + "midnight: 1\n" + "living: 1\n" + "blessed: 1\n" + "home: 1\n" + "michael: 1\n" + "print: 1\n" + "fiend: 1\n" + "501: 1\n" + "uttered: 1\n" + "promotion: 1\n" + "ebony: 1\n" + "state&#8217: 1\n" + "feather: 1\n" + "very: 1\n" + "newsletter: 1\n" + "transcription: 1\n" + "convert: 1\n" + "soon: 1\n" + "improved: 1\n" + "transcribe: 1\n" + "easily: 1\n" + "guessing: 1\n" + "made: 1\n" + "“be: 1\n" + "being: 1\n" + "distinctly: 1\n" + "gave: 1\n" + "alteration: 1\n" + "shrieked: 1\n" + "thinking: 1\n" + "streaming: 1\n" + "file: 1\n" + "world: 1\n" + "library: 1\n" + "aidenn: 1\n" + "legally: 1\n" + "december: 1\n" + "sending: 1\n" + "could: 1\n" + "change: 1\n" + "us&mdash: 1\n" + "indirectly: 1\n" + "wandering: 1\n" + "off: 1\n" + "machine: 1\n" + "unseen: 1\n" + "codes: 1\n" + "charities: 1\n" + "constant: 1\n" + "mail: 1\n" + "subject: 1\n" + "placid: 1\n" + "practically: 1\n" + "invalidity: 1\n" + "sign: 1\n" + "several: 1\n" + "main: 1\n" + "office: 1\n" + "seraphim: 1\n" + "faster: 1\n" + "revenue: 1\n" + "falls: 1\n" + "downloading: 1\n" + "peering: 1\n" + "claim: 1\n" + "widespread: 1\n" + "different: 1\n" + "directly: 1\n" + "international: 1\n" + "credit: 1\n" + "calculated: 1\n" + "syllable: 1\n" + "shore&mdash: 1\n" + "occur: 1\n" + "possessed: 1\n" + "foundation&#8221: 1\n" + "restrictions: 1\n" + "includes: 1\n" + "preserve: 1\n" + "throws: 1\n" + "friends: 1\n" + "utters: 1\n" + "forget: 1\n" + "disk: 1\n" + "professor: 1\n" + "dream: 1\n" + "attached: 1\n" + "evermore: 1\n" + "curtain: 1\n" + "errors: 1\n" + "appears: 1\n" + "head: 1\n" + "oh: 1\n" + "regulating: 1\n" + "met: 1\n" + "lordly: 1\n" + "determine: 1\n" + "sought: 1\n" + "stern: 1\n" + "master: 1\n" + "wrought: 1\n" + "pg: 1\n" + "infringement: 1\n" + "&#8217: 1\n" + "&#8216: 1\n" + "granted: 1\n" + "596: 1\n" + "thereat: 1\n" + "hundreds: 1\n" + "goals: 1\n" + "respite&mdash: 1\n" + "censer: 1\n" + "myself: 1\n" + "ancient: 1\n" + "balm: 1\n" + "remaining: 1\n" + "accept: 1\n" + "seat: 1\n" + "re: 1\n" + "processing: 1\n" + "donors: 1\n" + "interpreted: 1\n" + "shared: 1\n" + "discovered: 1\n" + "fact: 1\n" + "remember: 1\n" + "current: 1\n" + "variety: 1\n" + "plainly: 1\n" + "30: 1\n" + "stopped: 1\n" + "middle: 1\n" + "though: 1\n" + "manager: 1\n" + "weary: 1\n" + "enchanted&mdash: 1\n" + "makes: 1\n" + "store: 1\n" + "swamp: 1\n" + "appear: 1\n" + "trademark/copyright: 1\n" + "texts: 1\n" + "increasing: 1\n" + "compressed: 1\n" + "open: 1\n" + "commercial: 1\n" + "agent: 1\n" + "gilead: 1\n" + "exporting: 1\n" + "separate: 1\n" + "reasonable: 1\n" + "“or: 1\n" + "wished: 1\n" + "obeisance: 1\n" + "expressing: 1\n" + "rules: 1\n" + "express: 1\n" + "melancholy: 1\n" + "whenever: 1\n" + "50: 1\n" + "us: 1\n" + "ut: 1\n" + "yore&mdash: 1\n" + "felt: 1\n" + "modification: 1\n" + "sections: 1\n" + "especially: 1\n" + "once: 1\n" + "expend: 1\n" + "haunted&mdash: 1\n" + "84116: 1\n" + "know: 1\n" + "60: 1\n" + "64: 1\n" + "saintly: 1\n" + "allow: 1\n" + "lord: 1\n" + "beast: 1\n" + "assistance: 1\n" + "life: 1\n" + "proprietary: 1\n" + "lies: 1\n" + "performances: 1\n" + "types: 1\n" + "corrupt: 1\n" + "wide: 1\n" + "previous: 1\n" + "apply: 1\n" + "again: 1\n" + "reading: 1\n" + "thee&mdash: 1\n" + "eagerly: 1\n" + "lattice: 1\n" + "unprotected: 1\n" + "nonproprietary: 1\n" + "charitable: 1\n" + "problem: 1\n" + "divining: 1\n" + "crest: 1\n" + "“get: 1\n" + "profits: 1\n" + "method: 1\n" + "demon’s: 1\n" + "linking: 1\n" + "arise: 1\n" + "contract: 1\n" + "come: 1\n" + "provisions: 1\n" + "books: 1\n" + "stately: 1\n" + "outpour: 1\n" + "wore: 1\n" + "internal: 1\n" + "lore&mdash: 1\n" + "periodic: 1\n" + "north: 1\n" + "derive: 1\n" + "weak: 1\n" + "discontinue: 1\n" + "uniform: 1\n" + "lifted&mdash: 1\n" + "ghost: 1\n" + "seeing: 1\n" + "course: 1\n" + "hopes: 1\n" + "place: 1\n" + "include: 1\n" + "implore&mdash: 1\n" + "aged: 1\n" + "thou: 1\n" + "abide: 1\n" + "1887: 1\n" + "cease: 1\n" + "damaged: 1\n" + "exists: 1\n" + "scarce: 1\n" + "tufted: 1\n" + "addresses: 1\n" + "data: 1\n" + "rustling: 1\n" + "clearly: 1\n" + "sculptured: 1\n" + "desolate: 1\n" + "should: 1\n" + "discover: 1\n" + "curious: 1\n" + "indirect: 1\n" + "fluttered&mdash: 1\n" + "core: 1\n" + "provision: 1\n" + "flung: 1\n" + "org/license: 1\n" + "send: 1\n" + "tossed: 1\n" + "statements: 1\n" + "bends: 1\n" + "network: 1\n" + "paper: 1\n" + "array: 1\n" + "“wretch: 1\n" + "floating: 1\n" + "notifies: 1\n" + "grave: 1\n" + "undaunted: 1\n" + "follow: 1\n" + "unlink: 1\n" + "deductible: 1\n" + "aptly: 1\n" + "detach: 1\n" + "locations: 1\n" + "harmless: 1\n"));

        // Create the root layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(outputTextArea, analyzeButton);

        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.show();
    }

    /**
     * Analyzes the text given through the url.
     * @param s, as well url given for analysis.
     * @return no explicit return value, returned value is placed in the
     * outputTextArea.
     * @throws IOException If an error occurs while reading from the url.
     */
    public short analyzeText(String s) {
        try {
            // Get the URL of the web page containing the file to be read
            String urlStr = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
            URL url = new URL(urlStr);

            // Create a BufferedReader to read the web page line by line
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            // Ignore all text before the start of the poem
            String line;
            boolean inPoem = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("*** START OF THE PROJECT GUTENBERG EBOOK THE RAVEN ***")) {
                    inPoem = true;
                    break;
                }
            }

            // Read the poem's content and ignore all text after the end of the poem
            StringBuilder poemBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.contains("Shall be lifted—nevermore!")) {
                    break;
                }
                poemBuilder.append(line).append("\n");
            }
            String poem = poemBuilder.toString();

            // Remove all HTML tags
            poem = poem.replaceAll("<.*?>", "");

            // Tokenize the poem's content into words
            StringTokenizer tokenizer = new StringTokenizer(poem, " \t\n\r\f.,;:!?\"'-()[]{}");

            // Count the frequency of each word
            Map<String, Integer> wordFreqs = new HashMap<>();
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken().toLowerCase();
                Integer freq = wordFreqs.get(word);
                wordFreqs.put(word, freq == null ? 1 : freq + 1);
            }

            // Sort the words by frequency
            List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordFreqs.entrySet());
            Collections.sort(wordList, (a, b) -> b.getValue().compareTo(a.getValue()));

            // Update the TextArea with the word frequency statistics
            StringBuilder outputBuilder = new StringBuilder();
            for (Map.Entry<String, Integer> entry : wordList) {
                outputBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            outputTextArea.setText(outputBuilder.toString());

            // Close the reader
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


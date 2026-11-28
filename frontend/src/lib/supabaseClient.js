// supabaseClient.js
import { createClient } from "@supabase/supabase-js";

const supabaseUrl = "https://cswxwzjmyyrfkxesjngt.supabase.co";
const supabaseAnonKey = "sb_publishable_6fCF7pKvb9Zuc1qix2JkTA_H6snmk02";

export const supabase = createClient(supabaseUrl, supabaseAnonKey);